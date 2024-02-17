package com.example.nonameapp.network.serializable

import com.example.nonameapp.network.UUIDSerializer
import com.example.nonameapp.ui.dishesmenu.DishUIModel
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class DishResponseSerialization(
    val id: @Serializable(with = UUIDSerializer::class) UUID,
    val category: String,
    val name: String,
    val image_source: String,
    val price: Int,
    val grams: Int,
    val time_to_cook: Int,
    val rating: Float,
    val ordered_times: Int,
    val description: String,
    val ingredients: List<String>
){
    fun convertToDishUIModel() = DishUIModel(
        id, category, name, image_source, price, grams, time_to_cook, rating, ordered_times, description, ingredients
    )
}
