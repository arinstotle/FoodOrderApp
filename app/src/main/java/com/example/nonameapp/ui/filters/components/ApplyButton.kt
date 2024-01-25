package com.example.nonameapp.ui.filters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun ApplyButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(RedD8, OrangeD8)),
                shape = RoundedCornerShape(30.dp)
            ),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Unspecified
        )
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 24.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.ExtraBold
        )
    }
}