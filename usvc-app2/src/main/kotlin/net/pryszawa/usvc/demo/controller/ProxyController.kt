package net.pryszawa.usvc.demo.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import net.pryszawa.usvc.demo.service.ProxyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proxy")
class ProxyController(
    private val proxyService: ProxyService,
) {

    @Operation(
        summary = "A proxy to the echo endpoint in another microservice.",
        security = [
            SecurityRequirement(
                name = "OAuth2",
                scopes = [
                    "full-scope",
                ],
            )
        ],
    )
    @GetMapping("/echo/{message}")
    fun getProxyEcho(@PathVariable("message") message: String): ResponseEntity<String> =
        ResponseEntity.ok(proxyService.getProxyEcho(message))

}