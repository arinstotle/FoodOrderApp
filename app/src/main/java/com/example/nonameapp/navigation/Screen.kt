package com.example.nonameapp.navigation

sealed class Screen(val route : String) {
    object OnboardingScreen : Screen("onboarding_screen")
    object MainScreen : Screen("main_screen")
    object AuthorizationScreen : Screen("authorization_screen")
    object ProfileScreen : Screen("profile_screen")
}
