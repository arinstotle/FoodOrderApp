package com.example.nonameapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.navigation.Navigation
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.bottomNavigation.CustomBottomNavigation
import com.example.nonameapp.ui.theme.CustomBottomNavigationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            window.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
            window.navigationBarColor=MaterialTheme.colorScheme.background.toArgb()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                window.navigationBarDividerColor=MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1f).toArgb()
            }
            val currentScreen = mutableStateOf<Screen>(Screen.OnboardingScreen)
            CustomBottomNavigationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            when (NavigationRouter.currentScreen.value) {
                                Screen.OnboardingScreen, Screen.SettingsScreen,
                                Screen.AuthorizationScreen -> null
                                else -> {
                                    CustomBottomNavigation(currentScreenRoute = NavigationRouter.currentScreen.value.route) { screen ->
                                        NavigationRouter.currentScreen.value = screen
                                        navController.navigate(screen.route)
                                    }
                                }
                            }
                        }
                    ) {
                        contentPadding ->
                        run {
                            Box(modifier = Modifier.padding(contentPadding)) {
                                Navigation(navController)
                            }
                        }

                    }
                }
            }
        }
    }
}




