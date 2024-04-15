package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

/**
 * GetAllRestaurantsUseCase retrieves a list of all restaurants from the repository.
 *
 * @property repository The MainRepository instance to retrieve restaurants from.
 */
class GetAllRestaurantsUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to retrieve all restaurants.
     *
     * @return A list of RestaurantUIModel objects representing all restaurants.
     */
    suspend operator fun invoke(): List<RestaurantUIModel>? {
        return repository.getAllRestaurants()
    }
}
