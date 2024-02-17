package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import java.util.UUID

class ReserveTableUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(tableId: UUID): Boolean {
        val tablesRequest = TablesRequestChangeIsFreeSerialization(id = tableId, is_free = false)
        return repository.updateTableIsFree(tablesRequest)
    }
}