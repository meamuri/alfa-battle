package alfa.battle.atmsapplication

import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.util.ResourceUtils
import org.springframework.web.client.RestTemplate
import java.io.FileInputStream
import java.security.KeyStore


@Configuration
class Configuration {
    @Bean
    fun restTemplate(): RestTemplate {
        val ssl = SSLContextBuilder.create()
              .loadKeyMaterial(keyStore("classpath:keystore.jks"), password)
              .loadTrustMaterial(ResourceUtils.getFile("classpath:apidevelopers.key"))
              .build()
        val httpClient = HttpClients.custom().setSSLContext(ssl).build()
        val httpComponentsClientHttpRequestFactory = HttpComponentsClientHttpRequestFactory(httpClient)
        return RestTemplateBuilder().requestFactory { httpComponentsClientHttpRequestFactory }.build()
    }

    private fun keyStore(file: String): KeyStore {
        val keyStore = KeyStore.getInstance("PKCS12")
        val key = ResourceUtils.getFile(file)
        FileInputStream(key).use { keyStore.load(it, password) }
        return keyStore
    }
    companion object {
        private val password = "1234".toCharArray()
    }
}
