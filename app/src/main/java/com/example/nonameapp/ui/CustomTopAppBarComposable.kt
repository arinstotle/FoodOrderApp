package com.example.nonameapp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nonameapp.ui.theme.ReemKufi


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBarComposable(
    titleText: String,
    scrollBehavior: TopAppBarScrollBehavior,
    isHaveNavIcon: Boolean = false,
    onNavIconClick: () -> Unit = { },
    actions: @Composable() (RowScope.() -> Unit) = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                fontFamily = ReemKufi,
            )
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            scrolledContainerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {
            if(isHaveNavIcon){
                IconButton(onClick = { onNavIconClick() }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        },
        actions = actions,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp
                )
            ),

        )
}