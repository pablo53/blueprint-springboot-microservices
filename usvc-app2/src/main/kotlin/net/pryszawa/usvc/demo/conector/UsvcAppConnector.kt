package net.pryszawa.usvc.demo.conector

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class UsvcAppConnector(
    @Qualifier("defaultApiGatewayConnector") private var restTemplate: RestTemplate,
) {

    fun getEcho(message: String): ResponseEntity<String> =
        restTemplate.getForEntity("/echo/$message", String::class.java)

}
