package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

class ViewModelFactory(
    private val loginByEmail: LoginByEmailUseCase,
    private val getAllDishes: GetAllDishesUseCase,
    private val getAllDishesByCategory: GetAllDishesByCategoryUseCase,
    private val reserveTable: ReserveTableUseCase,
    private val getAllTables: GetAllTablesUseCase,
    private val getAllRestaurants: GetAllRestaurantsUseCase,
    private val getCurrentRestaurant: GetCurrentRestaurantUseCase,
    private val setCurrentRestaurant: SetCurrentRestaurantUseCase,
    private val getAllDishesInCartFlow: GetAllDishesInCartFlowUseCase,
    private val addToCart: AddToCartUseCase,
    private val getCurrentDishInDishInfo: GetCurrentDishInDishInfoUseCase,
    private val setCurrentDishInDishInfo: SetCurrentDishInDishInfoUseCase,
    private val increaseDishQuantity: IncreaseDishQuantityUseCase,
    private val decreaseDishQuantity: DecreaseDishQuantityUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthorizationViewModel::class.java) -> {
                AuthorizationViewModel(
                    loginByEmail = loginByEmail
                ) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(
                    getAllDishesInCartFlow = getAllDishesInCartFlow,
                    increaseDishQuantity = increaseDishQuantity,
                    decreaseDishQuantity = decreaseDishQuantity
                ) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(

                ) as T
            }
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(

                ) as T
            }
            modelClass.isAssignableFrom(DishesMenuViewModel::class.java) -> {
                DishesMenuViewModel(
                    getAllDishes = getAllDishes,
                    getAllDishesByCategory = getAllDishesByCategory,
                    setCurrentDishInDishInfo = setCurrentDishInDishInfo
                ) as T
            }
            modelClass.isAssignableFrom(ReservationViewModel::class.java) -> {
                ReservationViewModel(
                    getAllTables = getAllTables,
                    reserveTable = reserveTable
                ) as T
            }
            modelClass.isAssignableFrom(MapViewModel::class.java) -> {
                MapViewModel(
                    getAllRestaurants = getAllRestaurants,
                    getCurrentRestaurant = getCurrentRestaurant,
                    setCurrentRestaurant = setCurrentRestaurant
                ) as T
            }
            modelClass.isAssignableFrom(DishCardInfoViewModel::class.java) -> {
                DishCardInfoViewModel(
                    getCurrentDishInDishInfo = getCurrentDishInDishInfo,
                    addToCart = addToCart
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}