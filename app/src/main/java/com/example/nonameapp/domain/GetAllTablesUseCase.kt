package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.ui.reservation.components.TableUIModel
import java.util.UUID

class GetAllTablesUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(): List<TableUIModel>? {
        return repository.getTablesByRestaurantId(UUID.fromString("109bda53-7752-49be-9cf2-097a44b176e6"))
    }
}