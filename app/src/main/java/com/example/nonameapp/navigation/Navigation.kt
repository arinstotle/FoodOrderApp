package com.example.nonameapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.ui.reservation.ReservationComposable
import com.example.nonameapp.ui.mainscreen.MainScreen
import com.example.nonameapp.ui.cart.CartScreen
import com.example.nonameapp.ui.checkout.CheckoutScreen
import com.example.nonameapp.ui.dishesmenu.DishesMenuScreen
import com.example.nonameapp.ui.filters.FiltersComposable
import com.example.nonameapp.ui.map.MapController
import com.example.nonameapp.ui.map.MapScreen
import com.example.nonameapp.ui.newcard.NewCardScreen
import com.example.nonameapp.ui.onboarding.OnboardingScreen
import com.example.nonameapp.ui.profile.ProfileScreen
import com.example.nonameapp.ui.settings.SettingsScreen
import com.example.nonameapp.ui.signUp.AuthorizationScreen
import com.example.nonameapp.ui.splashscreen.SplashScreen
import com.example.nonameapp.util.DebugObject
import com.example.nonameapp.viewModels.AuthorizationViewModel
import com.example.nonameapp.viewModels.DishesMenuViewModel
import com.example.nonameapp.viewModels.MainViewModel
import com.example.nonameapp.viewModels.ReservationViewModel
import com.example.nonameapp.viewModels.ViewModelFactory

object NavigationRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.DishesMenuScreen)
}

@Composable
fun Navigation(
    navController: NavHostController,
    context: Context,
    sharedPreferenceHelper: SharedPreferenceHelper,
    mainViewModel: MainViewModel,
    viewModelFactory: ViewModelFactory
) {
    NavHost(navController = navController, startDestination = Screen.DishesMenuScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            NavigationRouter.currentScreen.value = Screen.SplashScreen
            SplashScreen(navController = navController, sharedPreferenceHelper)
        }
        composable(route = Screen.OnboardingScreen.route) {
            NavigationRouter.currentScreen.value = Screen.OnboardingScreen
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            NavigationRouter.currentScreen.value = Screen.MainScreen
            MainScreen(navController = navController, mainViewModel)
        }
        composable(route = Screen.AuthorizationScreen.route) {
            NavigationRouter.currentScreen.value = Screen.AuthorizationScreen

            val authorizationViewModel: AuthorizationViewModel =
                ViewModelProvider(it, viewModelFactory)[AuthorizationViewModel::class.java]

            AuthorizationScreen(
                navController = navController,
                authorizationViewModel = authorizationViewModel
            )
        }
        composable(route = Screen.ProfileScreen.route) {
            NavigationRouter.currentScreen.value = Screen.ProfileScreen
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.SettingsScreen.route) {
            NavigationRouter.currentScreen.value = Screen.SettingsScreen
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.DishesMenuScreen.route) {
            NavigationRouter.currentScreen.value = Screen.DishesMenuScreen

            val dishesMenuViewModel: DishesMenuViewModel =
                ViewModelProvider(it, viewModelFactory)[DishesMenuViewModel::class.java]


            DishesMenuScreen(
                navController = navController,
                viewModel = dishesMenuViewModel
            )
        }
        composable(route = Screen.CartScreen.route) {
            NavigationRouter.currentScreen.value = Screen.CartScreen
            CartScreen(navController = navController, mViewModel = DebugObject.cartViewModel)
        }
        composable(route = Screen.MapScreen.route) {
            NavigationRouter.currentScreen.value = Screen.MapScreen
            MapScreen(navController = navController, mapController = MapController(context))
        }
        composable(route = Screen.ReservationScreen.route) {
            NavigationRouter.currentScreen.value = Screen.ReservationScreen

            val reservationViewModel: ReservationViewModel =
                ViewModelProvider(it, viewModelFactory)[ReservationViewModel::class.java]

            ReservationComposable(navController = navController, viewModel = reservationViewModel)
        }
        composable(route = Screen.CheckoutScreen.route) {
            NavigationRouter.currentScreen.value = Screen.CheckoutScreen
            CheckoutScreen(navController = navController)
        }
        composable(route = Screen.NewCardScreen.route) {
            NavigationRouter.currentScreen.value = Screen.NewCardScreen
            NewCardScreen(navController = navController)
        }
        composable(route = Screen.FiltersScreen.route) {
            NavigationRouter.currentScreen.value = Screen.FiltersScreen
            FiltersComposable(navController = navController)
        }
    }
}

