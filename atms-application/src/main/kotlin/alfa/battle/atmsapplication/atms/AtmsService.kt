package alfa.battle.atmsapplication.atms

import alfa.battle.atmsapplication.atms.api.AlfaApiResponse
import alfa.battle.atmsapplication.config.AlfaIntegrationConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.util.UriComponentsBuilder

@Service
class AtmsService(
    @Autowired private val alfaIntegrationConfig: AlfaIntegrationConfig
) {
    private val baseUrl = UriComponentsBuilder.fromHttpUrl(alfaIntegrationConfig.apiBaseUrl).toUriString()
    private val getAtmsUrl = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/atms/").toUriString()
    @Autowired lateinit var restTemplate: RestTemplate

    fun findAtm(id: Int): AtmResponseSchema.AtmResponse? {
        logger.info("trying to find $id atm")
        val response: AlfaApiResponse = try {
            restTemplate.getForObject(getAtmsUrl)
        } catch (e: Exception) {
            logger.error("exception $e, result not found")
            return null
        }
        return response.data.find { it.deviceId == id }?.toAtmResponse()
    }

    private fun AlfaApiResponse.Data.toAtmResponse(): AtmResponseSchema.AtmResponse {
        val response = this
        return AtmResponseSchema.AtmResponse().apply {
            deviceId = response.deviceId
            city = response.address?.city
            latitude = response.coordinates?.latitude
            longitude = response.coordinates?.longitude
            payments = true
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AtmsService::class.java)
    }
}
