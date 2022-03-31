package net.pryszawa.usvc.demo.service

import no.finn.unleash.Unleash
import org.springframework.stereotype.Service

@Service
class FeatureToggleService(
    private val unleash: Unleash,
) {

    fun isEnabled(featureToggle: String) = unleash.isEnabled(featureToggle)

    fun isEnabled(featureToggle: String, defaultValue: Boolean) = unleash.isEnabled(featureToggle, defaultValue)

}
