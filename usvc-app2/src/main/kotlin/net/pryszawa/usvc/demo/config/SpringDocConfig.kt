package net.pryszawa.usvc.demo.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.OAuthFlow
import io.swagger.v3.oas.annotations.security.OAuthFlows
import io.swagger.v3.oas.annotations.security.OAuthScope
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.security.SecuritySchemes
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "App2 API",
        version = "1.0.0",
        description = "Application 2 (usvc-app2) API V1"
    ),
)
@SecuritySchemes(
    SecurityScheme(
        name = "OAuth2",
        type = SecuritySchemeType.OAUTH2,
        flows = OAuthFlows(
            clientCredentials = OAuthFlow(
                tokenUrl = "\${apigw.token.url}",
                scopes = [
                    OAuthScope(name = "full-scope", description = "An access to everything."),
                ],
            )
        )
    )
)
class SpringDocConfig
