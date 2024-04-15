package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import java.util.UUID

/**
 * ReserveTableUseCase reserves a table identified by its ID.
 *
 * @property repository The MainRepository instance to perform the table reservation.
 */
class ReserveTableUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to reserve a table.
     *
     * @param tableId The UUID of the table to reserve.
     * @return A boolean indicating the success of the reservation operation.
     */
    suspend operator fun invoke(tableId: UUID): Boolean {
        val tablesRequest = TablesRequestChangeIsFreeSerialization(id = tableId, is_free = false)
        return repository.updateTableIsFree(tablesRequest)
    }
}
