package com.example.nonameapp.di.modules

import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.viewModels.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @ActivityScope
    fun provideTaskViewModelFactory(
        loginByEmail: LoginByEmailUseCase,
        getAllDishes: GetAllDishesUseCase,
        reserveTable: ReserveTableUseCase,
        getAllTables: GetAllTablesUseCase
    ): ViewModelFactory = ViewModelFactory(
        loginByEmail = loginByEmail,
        getAllDishes = getAllDishes,
        reserveTable = reserveTable,
        getAllTables = getAllTables
    )

}