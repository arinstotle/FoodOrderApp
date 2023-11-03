package com.example.nonameapp.ui.cart

import androidx.lifecycle.ViewModel
import com.example.nonameapp.ui.carte.FoodDish
import com.example.nonameapp.ui.carte.FoodDishesDataSource

class CartViewModel: ViewModel() {

    private val dishesInCart: List<FoodDish> = FoodDishesDataSource.listOfFoodDishes.dropLast(4)

    fun getItemsInCart(): List<FoodDish> = dishesInCart

    fun getTotalCartSum(): Int {
        var sum = 0
        dishesInCart.forEach {dish ->
            sum += dish.price
        }
        return sum
    }
}