package com.example.nonameapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.ui.MainScreen
import com.example.nonameapp.ui.OnboardingScreen
import com.example.nonameapp.ui.ProfileScreen
import com.example.nonameapp.ui.carte.CarteScreen
import com.example.nonameapp.ui.settings.SettingsScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen
import com.example.nonameapp.ui.theme.OnboardingDemoTheme

@Composable
fun Navigation() {
    val navController = rememberNavController()
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
                CarteScreen()
            }
        }
    }
}

