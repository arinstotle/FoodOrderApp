package com.example.nonameapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nonameapp.ui.mainscreen.MainScreen
import com.example.nonameapp.ui.onboarding.OnboardingScreen
import com.example.nonameapp.ui.profile.ProfileScreen
import com.example.nonameapp.ui.cart.CartScreen
import com.example.nonameapp.ui.carte.CarteScreen
import com.example.nonameapp.ui.settings.SettingsScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen
import com.example.nonameapp.ui.theme.OnboardingDemoTheme

object NavigationRouter {
    var currentScreen : MutableState<Screen> = mutableStateOf(Screen.OnboardingScreen)
}

@Composable
fun Navigation(navController : NavHostController) {

    var isUiModeIsDark by remember {
        mutableStateOf( false
//            context.getSharedPreferences(
//                "prefs",
//                Context.MODE_PRIVATE
//            ).getBoolean("DAY_NIGHT_THEME_KEY", false)
        )
    }



    OnboardingDemoTheme(darkTheme = isUiModeIsDark) {
        NavHost(navController = navController, startDestination = Screen.OnboardingScreen.route) {
            composable(route = Screen.OnboardingScreen.route) {
                OnboardingScreen(navController = navController)
            }
            composable(route = Screen.MainScreen.route) {
                // i can add arguments here
                MainScreen(navController = navController)
            }
            composable(route = Screen.AuthorizationScreen.route) {
                AuthorizationScreen(navController = navController)
            }
            composable(route = Screen.ProfileScreen.route) {
                ProfileScreen(navController = navController)
            }
            composable(route = Screen.SettingsScreen.route) {
                SettingsScreen(navController = navController) {
                    isUiModeIsDark = !isUiModeIsDark

//                    context.getSharedPreferences(
//                        "prefs",
//                        Context.MODE_PRIVATE
//                    )
//                        .edit()
//                        .putBoolean("DAY_NIGHT_THEME_KEY", isUiModeIsDark)
//                        .apply()
                }
            }
            composable(route = Screen.CarteScreen.route){
                CarteScreen(navController = navController)
            }
            composable(route = Screen.CartScreen.route){
                CartScreen(navController = navController)
            }
        }
    }
}

