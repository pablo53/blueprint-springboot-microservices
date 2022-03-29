package net.pryszawa.usvc.demo.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class ConnectorConfig {

    @Bean
    @Qualifier("defaultApiGatewayConnector")
    fun defaultApiGatewayRestTemplate(@Value("\${apigw.url}") apiGatewayUrl: String): RestTemplate =
        RestTemplateBuilder()
            .rootUri(apiGatewayUrl)
            .build()

}