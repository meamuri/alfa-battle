package alfa.battle.atmsapplication.atms.api

import java.time.OffsetDateTime

class AlfaApiResponse(
    val data: List<Data>
) {
    class Data {
        var availableNow: AvailableNow? = null
        var deviceId: String? = null
        var recordUpdated: OffsetDateTime? = null
    }

    class AvailableNow {
        var cashIn: String? = null
        var cashOut: String? = null
        var online: String? = null
        var payments: String? = null
    }
}
