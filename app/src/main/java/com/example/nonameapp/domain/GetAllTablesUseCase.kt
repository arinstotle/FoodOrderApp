package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.ui.reservation.components.TableUIModel
import java.util.UUID

/**
 * GetAllTablesUseCase retrieves a list of all tables from the repository for a specific restaurant.
 *
 * @property repository The MainRepository instance to retrieve tables from.
 */
class GetAllTablesUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to retrieve all tables for a specific restaurant.
     *
     * @return A list of TableUIModel objects representing tables.
     */
    suspend operator fun invoke(): List<TableUIModel>? {
        return repository.getTablesByRestaurantId(UUID.fromString("109bda53-7752-49be-9cf2-097a44b176e6"))
    }
}
