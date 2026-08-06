package io.github.amanbutnot.kross_intents

expect object KrossIntents {
    fun openEmail(recipient: String, subject: String? = null, text: String? = null)
    fun openPhone(phone: String)
    fun openSms(phone: String, message: String? = null)
    fun openMaps(latitude: Double, longitude: Double)
    fun openSettings()
    fun openWifiSettings()
    fun openBluetoothSettings()
    fun openAppSettings()
}