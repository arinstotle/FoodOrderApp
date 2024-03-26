package com.example.nonameapp.di.modules

import com.example.nonameapp.di.scopes.ActivityScope
import com.example.nonameapp.domain.AddToCartUseCase
import com.example.nonameapp.domain.DecreaseDishQuantityUseCase
import com.example.nonameapp.domain.GetAllDishesByCategoryUseCase
import com.example.nonameapp.domain.GetAllDishesInCartFlowUseCase
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllRestaurantsUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.GetCurrentDishInDishInfoUseCase
import com.example.nonameapp.domain.GetCurrentRestaurantUseCase
import com.example.nonameapp.domain.IncreaseDishQuantityUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.domain.SetCurrentDishInDishInfoUseCase
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
        getAllDishesByCategory: GetAllDishesByCategoryUseCase,
        reserveTable: ReserveTableUseCase,
        getAllTables: GetAllTablesUseCase,
        getAllRestaurants: GetAllRestaurantsUseCase,
        getCurrentRestaurant: GetCurrentRestaurantUseCase,
        setCurrentRestaurant: SetCurrentRestaurantUseCase,
        getAllDishesInCartFlow: GetAllDishesInCartFlowUseCase,
        addToCart: AddToCartUseCase,
        getCurrentDishInDishInfo: GetCurrentDishInDishInfoUseCase,
        setCurrentDishInDishInfo: SetCurrentDishInDishInfoUseCase,
        increaseDishQuantity: IncreaseDishQuantityUseCase,
        decreaseDishQuantity: DecreaseDishQuantityUseCase
    ): ViewModelFactory = ViewModelFactory(
        loginByEmail = loginByEmail,
        getAllDishes = getAllDishes,
        getAllDishesByCategory = getAllDishesByCategory,
        reserveTable = reserveTable,
        getAllTables = getAllTables,
        getAllRestaurants = getAllRestaurants,
        getCurrentRestaurant = getCurrentRestaurant,
        setCurrentRestaurant = setCurrentRestaurant,
        getAllDishesInCartFlow = getAllDishesInCartFlow,
        addToCart = addToCart,
        getCurrentDishInDishInfo = getCurrentDishInDishInfo,
        setCurrentDishInDishInfo = setCurrentDishInDishInfo,
        increaseDishQuantity = increaseDishQuantity,
        decreaseDishQuantity = decreaseDishQuantity
    )

}