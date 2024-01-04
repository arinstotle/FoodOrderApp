package com.example.nonameapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.ui.reservation.ReservationComposable
import com.example.nonameapp.ui.mainscreen.MainScreen
import com.example.nonameapp.ui.cart.CartScreen
import com.example.nonameapp.ui.carte.CarteScreen
import com.example.nonameapp.ui.carte.CarteScreenOld
import com.example.nonameapp.ui.map.MapController
import com.example.nonameapp.ui.map.MapScreen
import com.example.nonameapp.ui.onboarding.OnboardingScreen
import com.example.nonameapp.ui.profile.ProfileScreen
import com.example.nonameapp.ui.settings.SettingsScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen
import com.example.nonameapp.ui.splashscreen.SplashScreen
import com.example.nonameapp.util.DebugObject
import com.example.nonameapp.viewModels.MainViewModel

object NavigationRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SplashScreen)
}

@Composable
fun Navigation(navController: NavHostController,
               context: Context,
               sharedPreferenceHelper: SharedPreferenceHelper,
               mainViewModel: MainViewModel
               ) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, mainViewModel)
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
            CartScreen(navController = navController, mViewModel = DebugObject.cartViewModel)
        }
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController, sharedPreferenceHelper)
        }
        composable(route = Screen.MapScreen.route) {
            MapScreen(navController = navController, mapController = MapController(context))
        }
        composable(route = Screen.ReservationScreen.route) {
            ReservationComposable(context = context)
        }
    }
}

