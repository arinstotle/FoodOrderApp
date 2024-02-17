package com.example.nonameapp.ui.reservation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.nonameapp.R
import com.example.nonameapp.ui.mainscreen.shimmerEffect
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientTableComponent(
    tileHeight: Dp,
    tileWidth: Dp,
    tableUIModel: TableUIModel,
    alphaAnimated: Float,
    onClick: suspend () -> Boolean
){
    val coroutineScope = rememberCoroutineScope()
    var isFree by remember { mutableStateOf(tableUIModel.isFree) }

    Box(
        modifier = Modifier
            .padding(
                start = tileWidth * tableUIModel.x,
                top = tileHeight * tableUIModel.y
            )
            .height(tileHeight * 2)
            .width(tileWidth * 3)
            .border(width = 1.dp, color = Color.Green.copy(alpha = alphaAnimated))
            .clickable {
                if(isFree){
                    coroutineScope.launch {
                        isFree = !onClick()
                    }
                }
            }
    ){
        BadgedBox(
            badge = {
                Badge(
                    containerColor = if(isFree) Color.Green else Color.Red,
                ) {
                    Text(
                        text = "0", // todo
                        color = Color.Black
                    )
                }
            }
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.table3x2),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun ClientTableShimmerComponent(
    tileHeight: Dp,
    tileWidth: Dp,
    tableUIModel: TableUIModel
) {
    Box(
        modifier = Modifier
            .padding(
                start = tileWidth * tableUIModel.x,
                top = tileHeight * tableUIModel.y
            )
            .height(tileHeight * 2)
            .width(tileWidth * 3)
//            .background(color = MaterialTheme.colorScheme.background)
            .shimmerEffect()
    )
}