package com.example.nonameapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val lightPalette = lightColorScheme(
    primary = OrangeD8,
    onPrimary = Black33,
    secondary = White,
    tertiary = Black14,
    background = WhiteFC,
    surface = White
)

private val darkPalette = darkColorScheme(
    primary = OrangeD8,
    onPrimary = Teal,
    secondary = Color.Black,
    tertiary = WhiteFC,
    background = Black1_28,
    surface = Black33
)

//@Composable
//fun CustomBottomNavigationTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable() () -> Unit
//) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }
//
//    MaterialTheme(
//        colorScheme = colors,
//        typography = Typography,
//        shapes = Shapes,
//        content = content
//    )
//}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val systemUiController: SystemUiController = rememberSystemUiController()
//    systemUiController.isStatusBarVisible = false // Hide StatusBar

    val colors: ColorScheme = if(darkTheme){
        darkPalette // change to DarkColorPalette
    }
    else{
        lightPalette
    }

    SetStatusBarColor(color = colors.background)

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )


}

@Composable
fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}