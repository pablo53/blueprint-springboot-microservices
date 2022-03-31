package net.pryszawa.usvc.demo.config

import no.finn.unleash.DefaultUnleash
import no.finn.unleash.Unleash
import no.finn.unleash.util.UnleashConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeatureToggleConfig {

    @Bean
    fun unleash(
        @Value("\${feature-toggle.unleash.app-name}") appName: String,
        @Value("\${feature-toggle.unleash.api-url}") unleashAPI: String,
        @Value("\${feature-toggle.unleash.environment}") environment: String,
        @Value("\${feature-toggle.unleash.instance-id}") instanceId: String,
        @Value("\${feature-toggle.unleash.client-secret}") clientSecret: String,
    ): Unleash =
        DefaultUnleash(
            UnleashConfig.builder()
                .appName(appName)
                .unleashAPI(unleashAPI)
                .environment(environment)
                .instanceId(instanceId)
                .customHttpHeader("Authorization", clientSecret)
                .build()
        )

}
