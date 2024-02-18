package com.example.nonameapp

import java.util.UUID

data class RestaurantUIModel (
    val id: UUID,
    val city: String,
    val street: String,
    val house: String,
    val latitude: Float,
    val longitude: Float
)