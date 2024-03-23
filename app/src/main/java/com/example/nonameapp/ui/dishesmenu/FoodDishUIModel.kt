package com.example.nonameapp.ui.dishesmenu

import androidx.annotation.DrawableRes
import com.example.nonameapp.FoodCategories
import com.example.nonameapp.data.model.CartDishUIModel

data class FoodDishUIModel(
    val id : String,
    val title : String,
    val category : FoodCategories,
    val price: String,
    val description: String,
    val weight : String,
    val calories : String,
    val kilojoules : String,
    val cookingTime : String,
    val rating : String,
    val reviews : String,
    val proteins : String,
    val fats : String,
    val carbohydrates : String,
    @DrawableRes
    val image: Int,
    val allergens : List<String>,
    val ingredients : List<Ingredient>
) {
    fun convertToCartUIModel(): CartDishUIModel {
        return CartDishUIModel(
            id = id,
            title = title,
            image = image,
            weight = weight,
            price = price,
            quantity = 0
        )
    }
}

data class Ingredient(
    val title: String,
    val subtitle : String,
    @DrawableRes
    val image : Int
)