package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nonameapp.domain.GetAllTablesUseCase
import com.example.nonameapp.domain.ReserveTableUseCase
import com.example.nonameapp.ui.reservation.components.ReservationDataSource
import com.example.nonameapp.ui.reservation.components.TableUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.UUID

class ReservationViewModel(
    val getAllTables: GetAllTablesUseCase,
    val reserveTable: ReserveTableUseCase
): ViewModel() {
    val listOfTables: Flow<List<TableUIModel>?> = flow {
        val dishes = getAllTables()
        emit(dishes)
    }

    suspend fun performReserveTable(tableId: UUID): Boolean{
        return reserveTable(tableId)
    }

}