package com.example.nonameapp.di.modules

import com.example.nonameapp.MainRepository
import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
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
}