package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.FoodDishesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel: ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _dishesInCart = MutableStateFlow(FoodDishesDataSource.listOfCartDishes)
    private val _totalCartSum = MutableStateFlow(0)

    // The UI collects from this StateFlow to get its state updates
    val dishesInCart: StateFlow<List<CartDishUIModel>> = _dishesInCart
    val totalCartSum: StateFlow<Int> = _totalCartSum

    init {
        calculateTotalCartSum()
    }

    fun getItemsInCart(): List<CartDishUIModel> = _dishesInCart.value

    fun calculateTotalCartSum() {
        var sum = 0

        dishesInCart.value.forEach { dish ->
            sum += dish.price.toInt() * dish.quantity
        }

        _totalCartSum.value = sum
    }

    fun addDishToCart(cartDishUIModel: CartDishUIModel){
        _dishesInCart.value.add(cartDishUIModel)
        calculateTotalCartSum()
    }
    fun removeDishFromCart(idDish: String){
        _dishesInCart.value.removeIf { it.id == idDish }
        calculateTotalCartSum()
    }
}