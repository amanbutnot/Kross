package io.github.amanbutnot.kross_intents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import io.github.kotlin.fibonacci.KrossApplication

@SuppressLint("UseKtx")
actual object KrossIntents {
    val context = KrossApplication.instance

    actual fun openEmail(recipient: String, subject: String?, text: String?) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$recipient")
            putExtra(Intent.EXTRA_SUBJECT, subject ?: "")
            putExtra(Intent.EXTRA_TEXT, text ?: "")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        }
        context.startActivity(intent)
    }

    actual fun openPhone(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    actual fun openSms(phone: String, message: String?) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("sms:$phone")
            putExtra("sms_body", message ?: "")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    actual fun openMaps(latitude: Double, longitude: Double) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:$latitude,$longitude")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    actual fun openSettings() {
        val intent = Intent(Settings.ACTION_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

//    actual fun openWifiSettings() {
//        val intent = Intent(Settings.ACTION_WIFI_SETTINGS).apply {
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        }
//        context.startActivity(intent)
//    }
//
//    actual fun openBluetoothSettings() {
//        val intent =
//            Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
//        context.startActivity(intent)
//    }

}