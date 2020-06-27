package alfa.battle.atmsapplication.atms

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("/atms")
class AtmsController(
        @Autowired private val atmsService: AtmsService
) {

    @GetMapping("/nearest")
    fun nearestAtms() {
    }

    @GetMapping("/{id}")
    fun getAtmById(@PathVariable id: String): ResponseEntity<AtmResponseSchema> {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(AtmResponseSchema.ErrorResponse("atm not found"))
    }
}
