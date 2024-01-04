package com.example.nonameapp

import android.app.Application
import com.example.nonameapp.di.components.AppComponent
import com.example.nonameapp.di.components.DaggerAppComponent
import com.yandex.mapkit.MapKitFactory

class FoodApplication : Application() {

    private var _applicationComponent: AppComponent? = null
    val applicationComponent: AppComponent get() = requireNotNull(_applicationComponent!!) {
        "AppComponent must not be null!"
    }

    override fun onCreate() {
        _applicationComponent = DaggerAppComponent.factory().create(this)
        applicationComponent.inject(this)
        super.onCreate()
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}