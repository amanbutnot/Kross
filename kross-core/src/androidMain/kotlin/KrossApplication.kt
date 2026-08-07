package io.github.kotlin.fibonacci

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