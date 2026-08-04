package io.github.amanbutnot.kross_clipboard.expect

import io.github.amanbutnot.kross_clipboard.enums.KlipData

expect class Klipboard {
    fun getData(klipData: KlipData): KlipData?
    fun saveData(klipData: KlipData)
}