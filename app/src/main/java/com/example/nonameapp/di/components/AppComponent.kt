package com.example.nonameapp.di.components

import android.content.Context
import com.example.nonameapp.FoodApplication
import com.example.nonameapp.di.modules.DatabaseModule
import com.example.nonameapp.di.modules.NetworkModule
import com.example.nonameapp.di.modules.RepositoryModule
import com.example.nonameapp.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DatabaseModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun activityComponent(): ActivityComponent
    fun inject(application: FoodApplication)
}