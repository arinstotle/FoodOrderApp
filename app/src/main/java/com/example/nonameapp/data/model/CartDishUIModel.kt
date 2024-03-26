package com.example.nonameapp.data.model

import java.util.UUID

data class CartDishUIModel(
    val id: UUID,
    val name: String,
    val imageSource: String,
    val grams: Int,
    val price: Int,
    var quantity: Int
)
