package com.example.nonameapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.ui.MainScreen
import com.example.nonameapp.ui.OnboardingScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
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
    }
}

