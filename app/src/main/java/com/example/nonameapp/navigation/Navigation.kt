package com.example.nonameapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nonameapp.ui.mainscreen.MainScreen
import com.example.nonameapp.ui.OnboardingScreen
import com.example.nonameapp.ui.ProfileScreen
import com.example.nonameapp.ui.cart.CartScreen
import com.example.nonameapp.ui.carte.CarteScreen
import com.example.nonameapp.ui.settings.SettingsScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen

object NavigationRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.OnboardingScreen)
}

@Composable
fun Navigation(navController: NavHostController) {

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
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.CarteScreen.route) {
            CarteScreen(navController = navController)
        }
        composable(route = Screen.CartScreen.route) {
            CartScreen(navController = navController)
        }
    }

}

