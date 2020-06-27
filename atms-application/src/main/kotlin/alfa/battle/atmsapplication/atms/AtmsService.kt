package alfa.battle.atmsapplication.atms

import alfa.battle.atmsapplication.atms.api.AlfaApiResponse
import alfa.battle.atmsapplication.config.AlfaIntegrationConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
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
            val request = HttpEntity<Any>("", HttpHeaders().apply {
                accept = listOf(MediaType.APPLICATION_JSON)
                set("x-ibm-client-id", alfaIntegrationConfig.clientSecret)
            })
            val responseEntity: ResponseEntity<AlfaApiResponse> = restTemplate.exchange(getAtmsUrl, HttpMethod.GET, request)
            responseEntity.body ?: return null
        } catch (e: Exception) {
            logger.error("exception $e, result not found")
            return null
        }

        return null
    }

//    private inline fun <reified T> RestTemplate.execute(url: String, method: HttpMethod): T {
//        val entity = HttpEntity<Any>("", HttpHeaders().apply {
//            accept = listOf(MediaType.APPLICATION_JSON)
//            set("x-ibm-client-id", "")
//        })
//        return restTemplate.exchange(url, method, entity, T::class)
//    }

    companion object {
        private val logger = LoggerFactory.getLogger(AtmsService::class.java)
    }
}
