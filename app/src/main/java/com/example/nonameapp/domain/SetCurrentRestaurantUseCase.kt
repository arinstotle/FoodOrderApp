package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

class SetCurrentRestaurantUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(restaurant: RestaurantUIModel) {
        repository.setCurrentRestaurant(restaurant)
    }
}