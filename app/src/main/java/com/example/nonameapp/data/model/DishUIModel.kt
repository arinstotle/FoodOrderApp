package com.example.nonameapp.data.model

import com.example.nonameapp.network.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * DishUIModel represents a dish in the application.
 *
 * @property id The unique identifier of the dish.
 * @property category The category of the dish.
 * @property name The name of the dish.
 * @property imageSource The image source URL of the dish.
 * @property price The price of the dish.
 * @property grams The weight of the dish in grams.
 * @property timeToCook The time required to cook the dish.
 * @property rating The rating of the dish.
 * @property orderedTimes The number of times the dish has been ordered.
 * @property description The description of the dish.
 * @property ingredients The list of ingredients in the dish.
 */
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
) {
    /**
     * Converts the DishUIModel to a CartDishUIModel for cart representation.
     *
     * @return A CartDishUIModel representing the dish in the cart.
     */
    fun convertToDishUIModel(): CartDishUIModel = CartDishUIModel(
        id = id,
        name = name,
        imageSource = imageSource,
        grams = grams,
        price = price,
        quantity = 1
    )
}

