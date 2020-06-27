package alfa.battle.atmsapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class AtmsApplication

fun main(args: Array<String>) {
    runApplication<AtmsApplication>(*args)
}
