package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.DishUIModel

class SetCurrentDishInDishInfoUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(dishUIModel: DishUIModel) {
        return repository.setCurrentDishInDishInfo(dishUIModel = dishUIModel)
    }
}