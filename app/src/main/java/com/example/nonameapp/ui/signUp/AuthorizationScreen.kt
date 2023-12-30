package com.example.nonameapp.ui.signUp

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpRouter
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpScreen
import com.example.nonameapp.ui.theme.Black1_28
import com.example.nonameapp.viewModels.AuthorizationViewModel

@Composable
fun AuthorizationScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Black1_28
    ) {
        Crossfade(targetState = SignUpRouter.currentScreen, label = "") { currentState ->
            when(currentState.value) {
                is SignUpScreen.RegistrationScreen -> {
                    RegistrationComposable(
                        viewModel()
                    ) {
                        NavigationRouter.currentScreen.value = Screen.MainScreen
                        navController.navigate(Screen.MainScreen.route)
                    }
                }
                is SignUpScreen.PrivacyPolicyScreen -> {
                    PrivacyPolicyComposable()
                }
                is SignUpScreen.LoginScreen -> {
                    LoginComposable(
                        viewModel()
                    ){
                        NavigationRouter.currentScreen.value = Screen.MainScreen
                        navController.navigate(Screen.MainScreen.route)
                    }
                }
                else -> {

                }
            }
        }
    }
}