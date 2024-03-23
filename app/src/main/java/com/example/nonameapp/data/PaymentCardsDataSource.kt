package com.example.nonameapp.data

import com.example.nonameapp.data.model.PaymentCardUIModel

object PaymentCardsDataSource {
    val listPaymentCards = listOf(
        PaymentCardUIModel(
            number = "4221 **** **** 9018",
            holder = "Nikita Novichkov",
            validUntil = "07/26",
            CVV = "***"
        ),
        PaymentCardUIModel(
            number = "4890 **** **** 7744",
            holder = "Nikita Novichkov",
            validUntil = "02/29",
            CVV = "***"
        )
    )
}