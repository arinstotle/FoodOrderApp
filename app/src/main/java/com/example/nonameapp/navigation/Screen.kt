package com.example.nonameapp.navigation

import com.example.nonameapp.R

sealed class Screen(val route : String, val icon : Int, val title : String) {
    object OnboardingScreen : Screen("onboarding_screen",
        title = "Onboarding", icon = R.drawable.google_icon)
    object MainScreen : Screen("main_screen",
        title = "Menu", icon = R.drawable.google_icon)
    object AuthorizationScreen : Screen("authorization_screen",
        title = "Auth", icon = R.drawable.google_icon)
    object ProfileScreen : Screen("profile_screen",
        title = "Profile", icon = R.drawable.google_icon)
    object SettingsScreen : Screen("settings_screen",
        title = "Settings", icon = R.drawable.google_icon)
    object DishesMenuScreen : Screen("dishes_menu_screen",
        title = "Menu", icon = R.drawable.google_icon)
    object CartScreen : Screen("cart_screen",
        title = "Cart", icon = R.drawable.google_icon)
    object SplashScreen : Screen("splash_screen",
        title = "Splash", icon = R.drawable.google_icon)
    object MapScreen : Screen("map_screen",
        title = "Map", icon = R.drawable.google_icon)
    object ReservationScreen : Screen("reservation_screen",
        title = "Tables", icon = R.drawable.google_icon)

    object Items{
        val list = listOf(
            MainScreen, ProfileScreen, DishesMenuScreen, MapScreen, ReservationScreen
        )
    }
}
