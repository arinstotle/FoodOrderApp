package com.example.nonameapp.data.model

/**
 * PaymentCardUIModel represents a payment card used in the application.
 *
 * @property number The card number (used as the card's ID).
 * @property holder The name of the card holder.
 * @property validUntil The expiration date of the card.
 * @property CVV The CVV (Card Verification Value) of the card.
 */
data class PaymentCardUIModel(
    val number: String,
    val holder: String,
    val validUntil: String,
    val CVV: String
)

