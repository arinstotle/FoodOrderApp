package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.DishUIModel

/**
 * GetAllDishesUseCase retrieves a list of all dishes from the repository.
 *
 * @property repository The MainRepository instance to retrieve dishes from.
 */
class GetAllDishesUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to retrieve all dishes.
     *
     * @return A list of DishUIModel objects representing all dishes.
     */
    suspend operator fun invoke(): List<DishUIModel>? {
        return repository.getAllDishes()
    }
}
