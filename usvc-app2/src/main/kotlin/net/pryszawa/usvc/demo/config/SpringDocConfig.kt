package net.pryszawa.usvc.demo.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "App2 API",
        version = "1.0.0",
        description = "Application 2 (usvc-app2) API V1"
    )
)
class SpringDocConfig
