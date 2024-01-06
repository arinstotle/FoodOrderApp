package com.example.nonameapp.ui.cart

data class CartDishUIModel(
    val id : String,
    val title : String,
    val image: Int,
    val weight : String,
    val price: String,
    var quantity: Int
)
