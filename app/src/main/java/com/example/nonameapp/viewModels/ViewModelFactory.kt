package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthorizationViewModel::class.java) -> {
                AuthorizationViewModel(

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

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}