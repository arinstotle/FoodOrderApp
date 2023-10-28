package com.example.nonameapp.ui.signUp

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpRouter
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpScreen

@Composable
fun AuthorizationScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = SignUpRouter.currentScreen, label = "") { currentState ->
            when(currentState.value) {
                is SignUpScreen.RegistrationScreen -> {
                    RegistrationComposable()
                }
                is SignUpScreen.PrivacyPolicyScreen -> {
                    PrivacyPolicyComposable()
                }
                is SignUpScreen.LoginScreen -> {
                    LoginComposable()
                }
                else -> {

                }
            }
        }
    }
}