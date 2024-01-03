package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.nonameapp.ui.theme.OrangeD8

@Composable
fun SocialNetworksComponent(
    icon1: ImageVector,
    icon2: ImageVector,
    onIcon1Click: () -> Unit,
    onIcon2Click: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ClickableIcon(icon1, onIcon1Click)
            ClickableIcon(icon2, onIcon2Click)
        }
    }
}

@Composable
fun ClickableIcon(
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.Transparent)
            .size(50.dp)
            .clickable {
                onClick()
            }
    ) {
        Icon(
            modifier = Modifier.fillMaxSize()
                .background(Color.Transparent),
            imageVector = icon,
            contentDescription = null,
            tint = OrangeD8
        )
    }
}