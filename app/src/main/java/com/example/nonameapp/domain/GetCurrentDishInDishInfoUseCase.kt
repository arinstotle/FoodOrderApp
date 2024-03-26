package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.DishUIModel

class GetCurrentDishInDishInfoUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(): DishUIModel? {
        return repository.getCurrentDishInDishInfo()
    }
}