package io.github.amanbutnot.kross_clipboard.expect

import io.github.amanbutnot.kross_clipboard.enums.KlipData
import io.github.amanbutnot.kross_clipboard.enums.KlipType
import platform.Foundation.NSData
import platform.Foundation.dataWithBytes
import platform.Foundation.dataWithData
import platform.UIKit.UIImage
import platform.UIKit.UIPasteboard

actual class Klipboard {
    val clip = UIPasteboard.generalPasteboard
    actual fun getData(klipType: KlipType): KlipData? {
        return when (klipType) {
            KlipType.HTML -> {
                KlipData.HTML(clip.string ?: "")
            }

            KlipType.TEXT -> {
                KlipData.TEXT(clip.string ?: "")
            }

            KlipType.URL -> {
                KlipData.URL(clip.string ?: "")
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