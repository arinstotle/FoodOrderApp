package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

class GetCurrentRestaurantUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(): RestaurantUIModel? {
        return repository.getCurrentRestaurant()
    }
}