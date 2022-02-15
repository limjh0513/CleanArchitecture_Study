package kr.hs.dgsw.storeproject.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StoreApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}