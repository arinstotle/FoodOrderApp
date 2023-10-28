package com.example.nonameapp.ui.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nonameapp.R
import com.example.nonameapp.ui.signUp.signUpNavigation.BackHandler
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpRouter
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpScreen
import com.example.nonameapp.ui.signUp.tinyComposableElements.OrdinaryTextComponent

@Composable
fun PrivacyPolicyComposable() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.White),
                    startY = 0f,
                    endY = 1f
                )
            )
            .padding(0.dp),
    ) {
        BackHandler {
            SignUpRouter.navigateTo(SignUpScreen.RegistrationScreen)
        }
       OrdinaryTextComponent(content = stringResource(id = R.string.privacy_policy), topPadding = 8,
           size = 26,
           fontWeight = FontWeight.Bold,
           heightMin = 0)
    }
}