package alfa.battle.atmsapplication.atms

import alfa.battle.atmsapplication.atms.api.AlfaApiResponse
import alfa.battle.atmsapplication.config.AlfaIntegrationConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.util.UriComponentsBuilder
import java.lang.Exception

@Service
class AtmsService(
    @Autowired private val alfaIntegrationConfig: AlfaIntegrationConfig
) {
    private val baseUrl = UriComponentsBuilder.fromHttpUrl(alfaIntegrationConfig.apiBaseUrl).toUriString()
    private val getAtmsUrl = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/atms/").toUriString()
    private val restTemplate = RestTemplate()

    fun findAtm(id: String): AtmResponseSchema.AtmResponse? {
        logger.info("trying to find $id atm")
        val response: AlfaApiResponse = try {
            restTemplate.getForObject(getAtmsUrl)
        } catch (e: Exception) {
            logger.error("exception $e, result not found")
            return null
        }

        return null
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AtmsService::class.java)
    }
}
