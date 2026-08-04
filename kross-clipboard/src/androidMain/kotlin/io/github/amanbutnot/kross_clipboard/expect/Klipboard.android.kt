package io.github.amanbutnot.kross_clipboard.expect

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import io.github.amanbutnot.kross_clipboard.enums.KlipData

actual class Klipboard(private val context: Context) {
    val clip = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    actual fun getData(klipData: KlipData): KlipData? {
        return when (klipData) {
            is KlipData.HTML -> {
                if (clip.hasPrimaryClip()) {
                    val a = clip.primaryClip
                    KlipData.HTML(a?.getItemAt(0)?.coerceToText(context).toString())
                } else {
                    null
                }
            }

            is KlipData.TEXT -> {
                if (clip.hasPrimaryClip()) {
                    val a = clip.primaryClip
                    KlipData.TEXT(a?.getItemAt(0)?.coerceToText(context).toString())
                } else {
                    null
                }
            }

            is KlipData.URL -> {
                if (clip.hasPrimaryClip()) {
                    val a = clip.primaryClip
                    KlipData.URL(a?.getItemAt(0)?.coerceToText(context).toString())
                } else {
                    null
                }
            }
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