package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.source.FoodDishesDataSource
import com.example.nonameapp.domain.DecreaseDishQuantityUseCase
import com.example.nonameapp.domain.GetAllDishesInCartFlowUseCase
import com.example.nonameapp.domain.IncreaseDishQuantityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class CartViewModel(
    getAllDishesInCartFlow: GetAllDishesInCartFlowUseCase,
    private val increaseDishQuantity: IncreaseDishQuantityUseCase,
    private val decreaseDishQuantity: DecreaseDishQuantityUseCase
): ViewModel() {
    val dishesInCart: StateFlow<List<CartDishUIModel>> = getAllDishesInCartFlow()

    fun performIncreaseDishQuantity(cartDishUIModel: CartDishUIModel) {
        increaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }

    fun performDecreaseDishQuantity(cartDishUIModel: CartDishUIModel) {
        decreaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }
}