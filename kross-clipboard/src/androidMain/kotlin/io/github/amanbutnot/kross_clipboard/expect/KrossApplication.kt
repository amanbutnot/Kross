package io.github.amanbutnot.kross_clipboard.expect

import android.app.Application

class KrossApplication : Application() {
    companion object {
        lateinit var instance: KrossApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}