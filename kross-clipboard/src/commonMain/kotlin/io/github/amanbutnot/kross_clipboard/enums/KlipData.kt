package io.github.amanbutnot.kross_clipboard.enums


sealed class KlipData {
    data class TEXT(val value: String) : KlipData()
    data class HTML(val value: String) : KlipData()
    data class URL(val value: String) : KlipData()
}

enum class KlipType {
    TEXT, HTML, URL
}