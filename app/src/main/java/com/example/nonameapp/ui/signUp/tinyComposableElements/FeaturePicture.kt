package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.annotation.DrawableRes

data class FeaturePicture(
    @DrawableRes val iconResource: Int,
    val contentDescription: String,
)