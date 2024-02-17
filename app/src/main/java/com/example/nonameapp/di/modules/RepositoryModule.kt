package com.example.nonameapp.di.modules

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.CacheSession
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    @AppScope
    fun provideCacheSession(): CacheSession = CacheSession()

    @Provides
    @AppScope
    fun provideMainRepository(
        preferenceHelper: SharedPreferenceHelper,
        cacheSession: CacheSession
    ): MainRepository = MainRepository(preferenceHelper, cacheSession)

}