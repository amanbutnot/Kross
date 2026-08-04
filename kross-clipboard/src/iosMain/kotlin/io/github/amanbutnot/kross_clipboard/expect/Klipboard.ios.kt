package io.github.amanbutnot.kross_clipboard.expect

import io.github.amanbutnot.kross_clipboard.enums.KlipData
import platform.UIKit.UIPasteboard

actual class Klipboard {
    val clip = UIPasteboard.generalPasteboard
    actual fun getData(klipData: KlipData): KlipData? {
        return when (klipData) {
            is KlipData.HTML -> {
                KlipData.TEXT(clip.string ?: "")
            }

            is KlipData.TEXT -> {
                KlipData.TEXT(clip.string ?: "")
            }

            is KlipData.URL -> {
                KlipData.TEXT(clip.string ?: "")
            }
        }
    }

    actual fun saveData(klipData: KlipData) {
        when (klipData) {
            is KlipData.HTML -> {
                clip.string = klipData.value
            }

            is KlipData.TEXT -> {
                clip.string = klipData.value
            }

            is KlipData.URL -> {
                clip.string = klipData.value
            }
        }
    }
}