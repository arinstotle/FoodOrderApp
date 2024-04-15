package com.example.nonameapp

import java.util.UUID

/**
 * RestaurantUIModel represents a restaurant in the application.
 *
 * @property id The unique identifier of the restaurant.
 * @property city The city where the restaurant is located.
 * @property street The street where the restaurant is located.
 * @property house The house number of the restaurant.
 * @property latitude The latitude coordinate of the restaurant's location.
 * @property longitude The longitude coordinate of the restaurant's location.
 */
data class RestaurantUIModel (
    val id: UUID,
    val city: String,
    val street: String,
    val house: String,
    val latitude: Float,
    val longitude: Float
)
