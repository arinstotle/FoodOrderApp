package com.example.nonameapp.data

data class PaymentCardUIModel(
    val number: String,     // using card's number as id
    val holder: String,
    val validUntil: String,
    val CVV: String
)
