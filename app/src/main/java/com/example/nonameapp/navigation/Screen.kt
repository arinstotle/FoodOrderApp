package com.example.nonameapp.navigation

import com.example.nonameapp.R

sealed class Screen(val route : String, val icon : Int, val title : String) {
    data object OnboardingScreen : Screen("onboarding_screen",
        title = "Onboarding", icon = R.drawable.google_icon)
    data object MainScreen : Screen("main_screen",
        title = "Home", icon = R.drawable.bottom_nav_home)
    data object AuthorizationScreen : Screen("authorization_screen",
        title = "Auth", icon = R.drawable.google_icon)
    data object ProfileScreen : Screen("profile_screen",
        title = "Profile", icon = R.drawable.bottom_nav_profile)
    data object SettingsScreen : Screen("settings_screen",
        title = "Settings", icon = R.drawable.google_icon)
    data object DishesMenuScreen : Screen("dishes_menu_screen",
        title = "Menu", icon = R.drawable.bottom_nav_menu_food)
    data object CartScreen : Screen("cart_screen",
        title = "Cart", icon = R.drawable.google_icon)
    data object SplashScreen : Screen("splash_screen",
        title = "Splash", icon = R.drawable.google_icon)
    data object MapScreen : Screen("map_screen",
        title = "Map", icon = R.drawable.bottom_nav_map)
    data object ReservationScreen : Screen("reservation_screen",
        title = "Tables", icon = R.drawable.bottom_nav_table)
    data object CheckoutScreen : Screen("checkout_screen",
        title = "Checkout", icon = R.drawable.google_icon)
    data object NewCardScreen : Screen("new_card_screen",
        title = "New card", icon = R.drawable.google_icon)
    data object FiltersScreen : Screen("filters_screen",
        title = "Filters", icon = R.drawable.google_icon)
    data object DishCardInfoScreen : Screen("dish_card_info_screen",
        title = "Dish", icon = R.drawable.google_icon)

    object Items{
        val list = listOf(
            MainScreen, ProfileScreen, DishesMenuScreen, MapScreen, ReservationScreen
        )
    }
}
