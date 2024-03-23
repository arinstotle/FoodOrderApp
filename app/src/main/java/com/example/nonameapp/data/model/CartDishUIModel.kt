package com.example.nonameapp.data.model

data class CartDishUIModel(
    val id : String,
    val title : String,
    val image: Int,
    val weight : String,
    val price: String,
    var quantity: Int
)
