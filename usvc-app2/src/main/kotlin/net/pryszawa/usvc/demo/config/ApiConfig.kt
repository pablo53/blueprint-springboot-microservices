package net.pryszawa.usvc.demo.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.AbstractRequestLoggingFilter
import javax.servlet.http.HttpServletRequest

@Configuration
class ApiConfig {

    companion object {

        val log = LoggerFactory.getLogger(ApiConfig::class.java)!!

    }

    @Bean
    @Qualifier("defaultLoggingFilter")
    fun loggingFilter(@Value("\${insights.logging.max-payload-length}") maxPayloadLength: Int) =
        object : AbstractRequestLoggingFilter() {

            override fun shouldLog(request: HttpServletRequest): Boolean = log.isInfoEnabled

            override fun beforeRequest(request: HttpServletRequest, message: String) = log.info(message)

            override fun afterRequest(request: HttpServletRequest, message: String) = log.info("Request processed.")

        }.apply {
            setBeforeMessagePrefix("Incoming Request: ")
            setIncludeQueryString(true)
            setIncludeHeaders(true)
            setIncludePayload(true)
            setMaxPayloadLength(maxPayloadLength)
        }

}