package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.data.source.FoodDishesDataSource
import com.example.nonameapp.domain.GetAllDishesByCategoryUseCase
import com.example.nonameapp.domain.GetAllDishesUseCase
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.domain.SetCurrentDishInDishInfoUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

class DishesMenuViewModel(
    val getAllDishes: GetAllDishesUseCase,
    val getAllDishesByCategory: GetAllDishesByCategoryUseCase,
    val setCurrentDishInDishInfo: SetCurrentDishInDishInfoUseCase
) : ViewModel() {

    private val listOfDishesWithCategories: MutableList<List<DishUIModel>?> = mutableListOf()

    val listOfDishes: Flow<List<DishUIModel>?> = flow {
        val dishes = getAllDishes()

        for(chip in FoodDishesDataSource.listOfChips){
            listOfDishesWithCategories.add(dishes?.filter { it.category == chip.chipName })
        }

        emit(dishes)
    }

    private val _listOfDishesByCategory = MutableStateFlow<List<DishUIModel>?>(null)
    val listOfDishesByCategory: StateFlow<List<DishUIModel>?> = _listOfDishesByCategory



    fun performGetAllDishesByCategory(categoryIndex: Int): List<DishUIModel>? {
        return listOfDishesWithCategories[categoryIndex]
    }

    fun performSetCurrentDishInDishInfo(dishUIModel: DishUIModel){
        setCurrentDishInDishInfo(dishUIModel = dishUIModel)
    }
}