package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.ui.dishesmenu.FoodDishUIModel
import com.example.nonameapp.ui.dishesmenu.FoodDishesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel: ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _dishesInCart = MutableStateFlow(FoodDishesDataSource.listOfFoodDishes.dropLast(4))
    private val _totalCartSum = MutableStateFlow(0)

    // The UI collects from this StateFlow to get its state updates
    val dishesInCart: StateFlow<List<FoodDishUIModel>> = _dishesInCart
    val totalCartSum: StateFlow<Int> = _totalCartSum

    init {
        calculateTotalCartSum()
    }

    fun getItemsInCart(): List<FoodDishUIModel> = _dishesInCart.value

    private fun calculateTotalCartSum() {
        var sum = 0

        dishesInCart.value.forEach {dish ->
            sum += dish.price.toInt()
        }

        _totalCartSum.value = sum
    }

    fun addDishToCart(foodDishUIModel: FoodDishUIModel){
        _dishesInCart.value = _dishesInCart.value.plus(foodDishUIModel)
        calculateTotalCartSum()
    }
    fun removeDishFromCart(idDish: String){
        _dishesInCart.value = _dishesInCart.value.filter { it.id != idDish }
        calculateTotalCartSum()
    }
}