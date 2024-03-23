package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.DishUIModel

class GetAllDishesByCategoryUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(category: String): List<DishUIModel>? {
        return repository.getAllDishesByCategory(category = category)
    }
}