package io.github.amanbutnot.kross_clipboard.expect

import io.github.amanbutnot.kross_clipboard.enums.KlipData
import io.github.amanbutnot.kross_clipboard.enums.KlipType
import kotlinx.cinterop.BetaInteropApi
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.UIKit.UIPasteboard

@Suppress("CAST_NEVER_SUCCEEDS")
actual class Klipboard {
    val clip = UIPasteboard.generalPasteboard

    @OptIn(BetaInteropApi::class)
    actual fun getData(klipType: KlipType): KlipData? {
        return when (klipType) {
            KlipType.TEXT -> {
                KlipData.TEXT(clip.string ?: "")
            }

            KlipType.HTML -> {
                val data = clip.dataForPasteboardType("public.html")

                data?.let {
                    KlipData.HTML(
                        NSString.create(
                            data = it,
                            encoding = NSUTF8StringEncoding
                        ).toString()
                    )
                }
            }

            KlipType.URL -> {
                clip.URL?.absoluteString?.let {
                    KlipData.URL(it)
                }
            }
        }
    }

    @OptIn(BetaInteropApi::class)
    actual fun saveData(klipData: KlipData) {
        when (klipData) {
            is KlipData.HTML -> {
                NSString.create(
                    string = klipData.value
                ).dataUsingEncoding(NSUTF8StringEncoding)?.let {
                    clip.setData(
                        it,
                        "public.html"
                    )
                }
            }

            is KlipData.TEXT -> {
                clip.string = klipData.value
            }

            is KlipData.URL -> {
                clip.URL = NSURL(string = klipData.value)
            }
        }
    }
}