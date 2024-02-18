package com.example.nonameapp.di.modules

import com.example.nonameapp.MainRepository
import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllRestaurantsUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.GetCurrentRestaurantUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.domain.SetCurrentRestaurantUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    @ActivityScope
    fun provideLoginByEmailUseCase(repository: MainRepository): LoginByEmailUseCase =
        LoginByEmailUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllDishesUseCase(repository: MainRepository): GetAllDishesUseCase =
        GetAllDishesUseCase(repository)

    @Provides
    @ActivityScope
    fun provideReserveTableUseCase(repository: MainRepository): ReserveTableUseCase =
        ReserveTableUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllTablesUseCase(repository: MainRepository): GetAllTablesUseCase =
        GetAllTablesUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetAllRestaurantsUseCase(repository: MainRepository): GetAllRestaurantsUseCase =
        GetAllRestaurantsUseCase(repository)

    @Provides
    @ActivityScope
    fun provideGetCurrentRestaurantUseCase(repository: MainRepository): GetCurrentRestaurantUseCase =
        GetCurrentRestaurantUseCase(repository)

    @Provides
    @ActivityScope
    fun provideSetCurrentRestaurantUseCase(repository: MainRepository): SetCurrentRestaurantUseCase =
        SetCurrentRestaurantUseCase(repository)
}