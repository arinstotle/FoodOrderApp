package com.example.nonameapp.data.source

import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.model.DishUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartManager {
    private val _dishesInCart = MutableStateFlow<MutableList<CartDishUIModel>>(mutableListOf())
    val dishesInCart: StateFlow<List<CartDishUIModel>> = _dishesInCart

    fun addToCart(dishUIModel: DishUIModel) {
        var foundedDish: CartDishUIModel? = null

        for(dish in _dishesInCart.value){
            if(dish.id == dishUIModel.id){
                foundedDish = dish
            }
        }

        if(foundedDish != null){
            foundedDish.quantity++
        }
        else {
            _dishesInCart.value.add(dishUIModel.convertToDishUIModel())
        }
    }

    fun increaseDishQuantity(cartDishUIModel: CartDishUIModel){
        cartDishUIModel.quantity++
    }

    fun decreaseDishQuantity(cartDishUIModel: CartDishUIModel){
        if(cartDishUIModel.quantity <= 1){
            _dishesInCart.value = _dishesInCart.value.minus(cartDishUIModel).toMutableList()
        }
        else{
            cartDishUIModel.quantity--
        }
    }
}