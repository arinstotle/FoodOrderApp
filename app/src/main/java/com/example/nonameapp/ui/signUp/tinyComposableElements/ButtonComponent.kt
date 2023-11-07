package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.ui.theme.FoodOnboardingBackground
import com.example.nonameapp.ui.theme.FoodOnboardingText
import com.example.nonameapp.ui.theme.MainInterfaceColor
import com.example.nonameapp.ui.theme.MainInterfaceColor_Red
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun ButtonComponent(text : String, onClickHandler : () -> Unit) {
    Button(onClick = onClickHandler,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        ,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(MainInterfaceColor_Red, MainInterfaceColor)),
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontFamily = ReemKufi,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }}
}