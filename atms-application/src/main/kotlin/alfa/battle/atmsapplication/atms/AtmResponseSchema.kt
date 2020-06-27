package alfa.battle.atmsapplication.atms

sealed class AtmResponseSchema {
    data class AtmResponse(
            var deviceId: Int? = null,
            var city: String? = null,
            var latitude: String? = null,
            var longitude: String? = null,
            var payments: Boolean? = null
    ) : AtmResponseSchema()

    data class ErrorResponse(val statue: String) : AtmResponseSchema()
}
