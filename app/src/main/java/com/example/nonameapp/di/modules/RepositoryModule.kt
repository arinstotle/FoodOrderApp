package com.example.nonameapp.di.modules

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.source.CacheSession
import com.example.nonameapp.data.source.CartManager
import com.example.nonameapp.data.source.SharedPreferenceHelper
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
    fun provideCartManager(): CartManager = CartManager()

    @Provides
    @AppScope
    fun provideMainRepository(
        preferenceHelper: SharedPreferenceHelper,
        cacheSession: CacheSession,
        cartManager: CartManager
    ): MainRepository = MainRepository(preferenceHelper, cacheSession, cartManager)

}