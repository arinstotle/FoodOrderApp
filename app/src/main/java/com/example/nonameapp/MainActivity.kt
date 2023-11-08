package com.example.nonameapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.navigation.Navigation
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.bottomNavigation.CustomBottomNavigation
import com.example.nonameapp.ui.map.MapScreen
import com.example.nonameapp.ui.map.MapController
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.Black1_28
import com.yandex.mapkit.MapKitFactory

class MainActivity : ComponentActivity() {



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
    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    companion object {
        const val MAPKIT_API_KEY = BuildConfig.MAPKIT_API_KEY
    }

    @RequiresApi(Build.VERSION_CODES.P)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setApiKey(savedInstanceState)
        MapKitFactory.initialize(this)

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
                                Screen.AuthorizationScreen, Screen.SplashScreen -> null
                                else -> {
                                    CustomBottomNavigation(currentScreenRoute = NavigationRouter.currentScreen.value.route) { screen ->
                                        if (screen.route != NavigationRouter.currentScreen.value.route) {
                                            NavigationRouter.currentScreen.value = screen
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
                                Navigation(navController, applicationContext)
                            }
                        }
                    }
                }
            }
        }
    }
}




