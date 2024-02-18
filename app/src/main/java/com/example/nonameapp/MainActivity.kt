package com.example.nonameapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.di.components.ActivityComponent
import com.example.nonameapp.navigation.Navigation
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.bottomNavigation.CustomBottomNavigation
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.viewModels.CartViewModel
import com.example.nonameapp.viewModels.MainViewModel
import com.example.nonameapp.viewModels.ViewModelFactory
import com.yandex.mapkit.MapKitFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private lateinit var activityComponent: ActivityComponent

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun setApiKey(savedInstanceState: Bundle?) {
        val haveApiKey = savedInstanceState?.getBoolean("haveApiKey") ?: false
        if (!haveApiKey) {
            MapKitFactory.setApiKey(MAPKIT_API_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("haveApiKey", true)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }
    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    companion object {
        const val MAPKIT_API_KEY = "2b6049c2-9bf3-4a6f-931e-cd3b3164f144"
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setApiKey(savedInstanceState)
        MapKitFactory.initialize(this)

        activityComponent = (applicationContext as FoodApplication).applicationComponent.activityComponent()
        activityComponent.inject(this)

        setContent {
            val navController = rememberNavController()
            window.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
            window.navigationBarColor = MaterialTheme.colorScheme.background.toArgb()
            AppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            when (NavigationRouter.currentScreen.value) {
                                Screen.OnboardingScreen, Screen.SettingsScreen,
                                Screen.AuthorizationScreen, Screen.SplashScreen,
                                Screen.CartScreen, Screen.CheckoutScreen,
                                Screen.NewCardScreen, Screen.FiltersScreen -> null
                                else -> {
                                    CustomBottomNavigation(currentScreenRoute = NavigationRouter.currentScreen.value.route) { screen ->
                                        if (screen.route != NavigationRouter.currentScreen.value.route) {
                                            navController.navigate(screen.route)
                                        }
                                    }
                                }
                            }
                        }
                    ) {
                        contentPadding ->
                        run {
                            Box(modifier = Modifier.padding(contentPadding)) {
                                Navigation(navController,
                                    applicationContext,
                                    sharedPreferenceHelper,
                                    mainViewModel,
                                    viewModelFactory)
                            }
                        }
                    }
                }
            }
        }
    }
}




