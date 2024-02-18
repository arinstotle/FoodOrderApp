package com.example.nonameapp.network.serializable

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.network.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class RestaurantsResponseSerialization(
    val id: @Serializable(with = UUIDSerializer::class) UUID,
    val city: String,
    val street: String,
    val house: String,
    val latitude: Float,
    val longitude: Float
) {
    fun convertToRestaurantUIModel() = RestaurantUIModel(
        id, city, street, house, latitude, longitude
    )
}