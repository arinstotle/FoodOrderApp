package com.example.nonameapp.ui.reservation.components

import java.util.UUID

data class TableUIModel(
    val id: UUID,
    val isFree: Boolean = true,
    val x: Int,
    val y: Int,
    val widthTiles: Int = 3,
    val heightTiles: Int = 2
)
