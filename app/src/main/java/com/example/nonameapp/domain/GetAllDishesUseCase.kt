package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.ui.dishesmenu.DishUIModel

class GetAllDishesUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(): List<DishUIModel>? {
        return repository.getAllDishes()
    }
}