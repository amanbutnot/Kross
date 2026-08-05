package io.github.amanbutnot.kross_clipboard.expect

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import io.github.amanbutnot.kross_clipboard.enums.KlipData
import io.github.amanbutnot.kross_clipboard.enums.KlipType

actual class Klipboard(private val context: Context) {
    val clip = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    actual fun getData(klipType: KlipType): KlipData? {
        return if (clip.hasPrimaryClip()) {
            val mainClip = clip.primaryClip
            when (klipType) {
                KlipType.HTML -> {

                    KlipData.HTML(mainClip?.getItemAt(0)?.coerceToText(context).toString())

                }

                KlipType.TEXT -> {

                    KlipData.TEXT(mainClip?.getItemAt(0)?.coerceToText(context).toString())

                }

                KlipType.URL -> {


                    KlipData.URL(mainClip?.getItemAt(0)?.coerceToText(context).toString())

                }
            }
        } else {
            null
        }

    }

    actual fun saveData(klipData: KlipData) {
        when (klipData) {
            is KlipData.HTML -> {
                val data = ClipData.newPlainText("html", klipData.value)
                clip.setPrimaryClip(data)
            }

            is KlipData.TEXT -> {
                val data = ClipData.newPlainText("text", klipData.value)
                clip.setPrimaryClip(data)
            }

            is KlipData.URL -> {
                val data = ClipData.newPlainText("url", klipData.value)
                clip.setPrimaryClip(data)
            }
        }

    }
}