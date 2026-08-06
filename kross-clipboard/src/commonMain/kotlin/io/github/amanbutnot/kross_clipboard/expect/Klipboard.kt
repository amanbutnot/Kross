package io.github.amanbutnot.kross_clipboard.expect

import io.github.amanbutnot.kross_clipboard.enums.KlipData
import io.github.amanbutnot.kross_clipboard.enums.KlipType

expect class Klipboard() {
    fun getData(klipType: KlipType): KlipData?
    fun saveData(klipData: KlipData)
}