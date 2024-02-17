package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.LoginByEmailUseCase
import com.example.nonameapp.domain.ReserveTableUseCase

class ViewModelFactory(
    private val loginByEmail: LoginByEmailUseCase,
    private val getAllDishes: GetAllDishesUseCase,
    private val reserveTable: ReserveTableUseCase,
    private val getAllTables: GetAllTablesUseCase,
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
                    getAllDishes = getAllDishes
                ) as T
            }
            modelClass.isAssignableFrom(ReservationViewModel::class.java) -> {
                ReservationViewModel(
                    getAllTables = getAllTables,
                    reserveTable = reserveTable
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}