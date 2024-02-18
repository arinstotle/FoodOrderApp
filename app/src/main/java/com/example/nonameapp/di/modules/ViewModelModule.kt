package com.example.nonameapp.di.modules

import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllRestaurantsUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.GetCurrentRestaurantUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.domain.SetCurrentRestaurantUseCase
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
        getAllTables: GetAllTablesUseCase,
        getAllRestaurants: GetAllRestaurantsUseCase,
        getCurrentRestaurant: GetCurrentRestaurantUseCase,
        setCurrentRestaurant: SetCurrentRestaurantUseCase
    ): ViewModelFactory = ViewModelFactory(
        loginByEmail = loginByEmail,
        getAllDishes = getAllDishes,
        reserveTable = reserveTable,
        getAllTables = getAllTables,
        getAllRestaurants = getAllRestaurants,
        getCurrentRestaurant = getCurrentRestaurant,
        setCurrentRestaurant = setCurrentRestaurant
    )

}