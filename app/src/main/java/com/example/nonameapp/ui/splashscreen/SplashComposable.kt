package com.example.nonameapp.ui.splashscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nonameapp.R
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.theme.Black1_28
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,
                 sharedPreferenceHelper: SharedPreferenceHelper) {
    var animated by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(initialValue = 360f) }
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(true) {
        delay(350)
        visible = !visible
        delay(500)
        animated = !animated
        delay(1000)
        visible = !visible
        delay(270)
        if (sharedPreferenceHelper.getShouldShowOnboarding()) {
            sharedPreferenceHelper.setShouldShowOnboarding(true)
            NavigationRouter.currentScreen.value = Screen.OnboardingScreen
            navController.navigate(Screen.OnboardingScreen.route)
        } else {
            if (sharedPreferenceHelper.getCurrentAuthUser() != null) {
                NavigationRouter.currentScreen.value = Screen.MainScreen
                navController.navigate(Screen.MainScreen.route)
            } else {
                NavigationRouter.currentScreen.value = Screen.AuthorizationScreen
                navController.navigate(Screen.AuthorizationScreen.route)
            }
        }
    }
    LaunchedEffect(animated) {
        rotation.animateTo(
            targetValue = if (animated) 0f else 360f,
            animationSpec = tween(durationMillis = 1000),
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black1_28)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally() + expandHorizontally(expandFrom = Alignment.End)
                    + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
                    + shrinkHorizontally() + fadeOut(),
        ) {
            Box(
                modifier = Modifier.size(200.dp).background(Black1_28),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize()
                        .graphicsLayer {
                            rotationY = rotation.value
                        },
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}