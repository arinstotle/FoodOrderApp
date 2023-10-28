package com.example.nonameapp.ui.signUp.signUpNavigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object SignUpRouter {
    var currentScreen : MutableState<SignUpScreen> = mutableStateOf(SignUpScreen.RegistrationScreen)
    fun navigateTo(destination : SignUpScreen) {
        currentScreen.value = destination
    }
}