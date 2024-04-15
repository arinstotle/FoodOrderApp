package com.example.nonameapp.ui.reservation.components

import java.util.UUID

/**
 * TableUIModel represents a table in the application.
 *
 * @property id The unique identifier of the table.
 * @property isFree A boolean indicating whether the table is free or not.
 * @property x The x-coordinate of the table's position.
 * @property y The y-coordinate of the table's position.
 * @property widthTiles The width of the table in tiles.
 * @property heightTiles The height of the table in tiles.
 */
data class TableUIModel(
    val id: UUID,
    val isFree: Boolean = true,
    val x: Int,
    val y: Int,
    val widthTiles: Int = 3,
    val heightTiles: Int = 2
)

