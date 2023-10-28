package com.example.nonameapp.ui.signUp.signUpNavigation

sealed class SignUpScreen {
    object RegistrationScreen : SignUpScreen()
    object TermsOfUseScreen : SignUpScreen()
    object PrivacyPolicyScreen : SignUpScreen()
    object LoginScreen : SignUpScreen()
}
