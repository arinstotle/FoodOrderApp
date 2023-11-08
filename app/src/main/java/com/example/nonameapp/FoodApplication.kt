package com.example.nonameapp

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class FoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}