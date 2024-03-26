package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.model.DishUIModel
import kotlinx.coroutines.flow.StateFlow

class IncreaseDishQuantityUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(cartDishUIModel: CartDishUIModel) {
        repository.increaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }
}