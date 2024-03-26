package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.model.DishUIModel
import kotlinx.coroutines.flow.StateFlow

class AddToCartUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(dishUIModel: DishUIModel) {
        return repository.addToCart(dishUIModel)
    }
}