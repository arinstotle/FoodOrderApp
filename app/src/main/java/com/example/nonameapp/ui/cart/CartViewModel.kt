package com.example.nonameapp.ui.cart

import androidx.lifecycle.ViewModel
import com.example.nonameapp.ui.carte.FoodDishUIModel
import com.example.nonameapp.ui.carte.FoodDishesDataSource

class CartViewModel: ViewModel() {

    private var dishesInCart: List<FoodDishUIModel> = FoodDishesDataSource.listOfFoodDishes.dropLast(4)

    fun getItemsInCart(): List<FoodDishUIModel> = dishesInCart

    fun getTotalCartSum(): Int {
        var sum = 0
        dishesInCart.forEach {dish ->
            sum += dish.price.toInt()
        }
        return sum
    }

    fun removeDishFromCart(idDish: String){
        dishesInCart = dishesInCart.filter { it.id != idDish }
    }
}