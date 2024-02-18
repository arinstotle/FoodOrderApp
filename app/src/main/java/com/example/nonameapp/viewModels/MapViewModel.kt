package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.domain.GetAllRestaurantsUseCase
import com.example.nonameapp.domain.GetCurrentRestaurantUseCase
import com.example.nonameapp.domain.SetCurrentRestaurantUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MapViewModel(
    private val getAllRestaurants: GetAllRestaurantsUseCase,
    private val getCurrentRestaurant: GetCurrentRestaurantUseCase,
    private val setCurrentRestaurant: SetCurrentRestaurantUseCase
): ViewModel() {
    val listOfRestaurants: Flow<List<RestaurantUIModel>?> = flow {
        emit(getAllRestaurants())
    }
}