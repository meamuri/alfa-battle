package alfa.battle.atmsapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AtmsApplication

fun main(args: Array<String>) {
    runApplication<AtmsApplication>(*args)
}
