package io.github.amanbutnot.kross_intents

import platform.Foundation.NSCharacterSet
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.URLQueryAllowedCharacterSet
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString
//email not working, sms not picking the number, phone not workin
actual object KrossIntents {
    actual fun openEmail(recipient: String, subject: String?, text: String?) {
        val encodedSubject = subject?.let {
            (it as NSString).stringByAddingPercentEncodingWithAllowedCharacters(
                NSCharacterSet.URLQueryAllowedCharacterSet
            )
        } ?: ""
        val encodedBody = text?.let {
            (it as NSString).stringByAddingPercentEncodingWithAllowedCharacters(
                NSCharacterSet.URLQueryAllowedCharacterSet
            )
        } ?: ""
        val url = NSURL.URLWithString("mailto:$recipient?subject=$encodedSubject&body=$encodedBody")
            ?: return
        openUrl(url)
    }

    actual fun openPhone(phone: String) {
        val url = NSURL.URLWithString("tel:$phone") ?: return
        openUrl(url)
    }

    actual fun openSms(phone: String, message: String?) {
        val encodedMessage = message?.let {
            (it as NSString).stringByAddingPercentEncodingWithAllowedCharacters(
                NSCharacterSet.URLQueryAllowedCharacterSet
            )
        }
        val url = NSURL.URLWithString("sms://$phone?body=${encodedMessage}") ?: return
        openUrl(url)
    }

    actual fun openMaps(latitude: Double, longitude: Double) {
        val url = NSURL.URLWithString("maps://?ll=$latitude,$longitude") ?: return
        openUrl(url)
    }

    actual fun openSettings() {
        val url = NSURL.URLWithString(UIApplicationOpenSettingsURLString) ?: return
        openUrl(url)
    }

    private fun openUrl(url: NSURL) {
            UIApplication.sharedApplication.openURL(url, options = emptyMap<Any?, Any?>(), null)

    }
}
