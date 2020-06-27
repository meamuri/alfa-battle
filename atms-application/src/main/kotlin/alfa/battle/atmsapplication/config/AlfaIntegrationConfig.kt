package alfa.battle.atmsapplication.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "integration.alfa")
@Validated
@Component
class AlfaIntegrationConfig{
    lateinit var apiBaseUrl: String
    lateinit var clientSecret: String
    lateinit var clientId: String
}
