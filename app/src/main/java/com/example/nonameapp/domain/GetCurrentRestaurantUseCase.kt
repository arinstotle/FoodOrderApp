package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.RestaurantUIModel

/**
 * GetCurrentRestaurantUseCase retrieves the currently selected restaurant from the repository.
 *
 * @property repository The MainRepository instance to retrieve the current restaurant from.
 */
class GetCurrentRestaurantUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to retrieve the currently selected restaurant.
     *
     * @return The current RestaurantUIModel object.
     */
    operator fun invoke(): RestaurantUIModel? {
        return repository.getCurrentRestaurant()
    }
}
