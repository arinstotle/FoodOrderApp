package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.model.DishUIModel
import kotlinx.coroutines.flow.StateFlow

class GetSumCartFlowUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(): StateFlow<Int> {
        return repository.getSumCartStateFlow()
    }
}