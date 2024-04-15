package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.DishUIModel

/**
 * GetAllDishesByCategoryUseCase retrieves a list of dishes filtered by category from the repository.
 *
 * @property repository The MainRepository instance to retrieve dishes from.
 */
class GetAllDishesByCategoryUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to retrieve dishes filtered by the specified category.
     *
     * @param category The category to filter dishes by.
     * @return A list of DishUIModel objects filtered by the category.
     */
    operator fun invoke(category: String): List<DishUIModel>? {
        return repository.getAllDishesByCategory(category = category)
    }
}
