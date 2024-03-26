package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.domain.AddToCartUseCase
import com.example.nonameapp.domain.GetCurrentDishInDishInfoUseCase

class DishCardInfoViewModel(
    private val addToCart: AddToCartUseCase,
    private val getCurrentDishInDishInfo: GetCurrentDishInDishInfoUseCase
): ViewModel() {

    fun performGetCurrentDish(): DishUIModel? {
        return getCurrentDishInDishInfo()
    }
    fun performAddToCart(){
        val currentDish = getCurrentDishInDishInfo()

        if(currentDish != null){
            addToCart(dishUIModel = currentDish)
        }
    }
}