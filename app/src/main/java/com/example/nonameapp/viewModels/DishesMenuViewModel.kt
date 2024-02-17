package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.ui.dishesmenu.DishUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DishesMenuViewModel(
    val getAllDishes: GetAllDishesUseCase
): ViewModel() {
    val listOfDishes: Flow<List<DishUIModel>?> = flow {
        val dishes = getAllDishes()
        emit(dishes)
    }
//    init {
//        viewModelScope.launch{
//            getAllDishes()
//        }
//    }
}