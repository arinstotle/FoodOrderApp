package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

class GetAllRestaurantsUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(): List<RestaurantUIModel>? {
        return repository.getAllRestaurants()
    }
}