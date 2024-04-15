package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

/**
 * SetCurrentRestaurantUseCase sets the current restaurant in the repository.
 *
 * @property repository The MainRepository instance to set the current restaurant.
 */
class SetCurrentRestaurantUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to set the current restaurant.
     *
     * @param restaurant The RestaurantUIModel object to set as the current restaurant.
     */
    operator fun invoke(restaurant: RestaurantUIModel) {
        repository.setCurrentRestaurant(restaurant)
    }
}
