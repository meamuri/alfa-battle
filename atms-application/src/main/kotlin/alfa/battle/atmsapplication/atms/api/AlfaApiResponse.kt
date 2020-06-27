package alfa.battle.atmsapplication.atms.api

import java.time.OffsetDateTime

class AlfaApiResponse(
    val data: List<Data>,
    val bankLicense: String
) {
    class Data {
        var deviceId: Int? = null
        var address: Address? = null
        var addressComments: String? = null
        var availablePaymentSystems: List<String>? = null
        var cashInCurrencies: List<String>? = null
        var cashOutCurrencies: List<String>? = null
        var coordinates: Coordinates? = null
        var nfc: String? = null
        var publicAccess: String? = null
        var recordUpdated: OffsetDateTime? = null
        var timeShift: Int? = null
        var timeAccess: TimeAccess? = null
        var supportInfo: SupportInfo? = null
        var services: Services? = null
    }

    class Services {
        var cardCashOut: String? = null
        var cardCashIn: String? = null
        var cardPayments: String? = null
        var cashIn: String? = null
        var cashOut: String? = null
        var payments: String? = null
    }

    class SupportInfo {
        var email: String? = null
        var other: String? = null
        var phone: String? = null
    }

    data class TimeAccess(val mode: String, val schedule: String)

    data class Coordinates(var latitude: String, var longitude: String)

    class Address {
        var city: String? = null
        var location: String? = null
        var mode: String? = null
    }
}
