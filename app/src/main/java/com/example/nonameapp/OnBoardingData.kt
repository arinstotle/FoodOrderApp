package com.example.nonameapp

import androidx.compose.ui.graphics.Color

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor : Color,
    val mainColor : Color = Color.Blue,
    val gradientColor : Color
)
