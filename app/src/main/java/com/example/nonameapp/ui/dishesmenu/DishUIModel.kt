package com.example.nonameapp.ui.dishesmenu

import com.example.nonameapp.FoodCategories
import com.example.nonameapp.network.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class DishUIModel(
    val id: @Serializable(with = UUIDSerializer::class) UUID,
    val category: String,
    val name: String,
    val imageSource: String,
    val price: Int,
    val grams: Int,
    val timeToCook: Int,
    val rating: Float,
    val orderedTimes: Int,
    val description: String,
    val ingredients: List<String>
)
