package net.pryszawa.usvc.demo.config

import net.pryszawa.usvc.demo.service.FeatureToggleService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

@Configuration
class ConnectorConfig {

    companion object {

        val log = LoggerFactory.getLogger(ConnectorConfig::class.java)!!

    }

    @Bean
    @Qualifier("defaultApiGatewayConnector")
    fun defaultApiGatewayRestTemplate(
        @Value("\${apigw.url}") apiGatewayUrl: String,
        @Autowired @Qualifier("defaultLoggerInterceptor") clientHttpRequestInterceptor: ClientHttpRequestInterceptor,
    ): RestTemplate =
        RestTemplateBuilder()
            .rootUri(apiGatewayUrl)
            .interceptors(clientHttpRequestInterceptor)
            .requestFactory {
                BufferingClientHttpRequestFactory( // a wrapper for logging interceptor to reread body
                    HttpComponentsClientHttpRequestFactory() // Apache HTTP components allow PATCH method, but it could be SimpleClientHttpRequestFactory() for standard JDK http clients
                )
            }
            .build()

    @Bean
    @Qualifier("defaultLoggerInterceptor")
    fun loggerInterceptor(
        @Autowired featureToggleService: FeatureToggleService,
    ) =
        ClientHttpRequestInterceptor { request, body, execution ->
            val loggingEnabled = log.isInfoEnabled && featureToggleService.isEnabled("usvc.log-payloads", false)
            if (loggingEnabled) {
                val requestInfo =
                    "Request to ${request.methodValue}  ${request.uri}\n" +
                            request.headers
                                .flatMap { hdr -> hdr.value.map { value -> hdr.key to value } }
                                .joinToString(separator = "\n", prefix = "HEADERS:\n", postfix = "\n") { "${it.first}: ${it.second}" } +
                            "BODY (length=${body.size}):\n" + String(body, StandardCharsets.UTF_8)
                log.info(requestInfo)
            }
            val response = execution.execute(request, body)
            if (loggingEnabled) {
                val responseInfo =
                    "Response from ${request.methodValue}  ${request.uri}\n" +
                            response.headers
                                .flatMap { hdr -> hdr.value.map { value -> hdr.key to value } }
                                .joinToString(separator = "\n", prefix = "HEADERS:\n", postfix = "\n") { "${it.first}: ${it.second}" } +
                            BufferedReader(InputStreamReader(response.body, StandardCharsets.UTF_8))
                                .lines()
                                .collect(Collectors.joining("\n"))
                                .let { respBody -> "BODY:\n$respBody\n" }
                log.info(responseInfo)
            }
            response
        }

}