package com.example.nonameapp.ui.onboarding

import com.example.nonameapp.R

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
)

val items = listOf<OnBoardingData>(OnBoardingData(
    R.drawable.burger_onboarding,
    "Text1",
    "Tiny text1",
),
    OnBoardingData(
        R.drawable.stew_onboarding,
        "Text2",
        "Tiny text2",
    ),
    OnBoardingData(
        R.drawable.meat_onboarding,
        "Text3",
        "Tiny text2",
    )
)