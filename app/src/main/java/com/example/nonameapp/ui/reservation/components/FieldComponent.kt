package com.example.nonameapp.ui.reservation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun FieldComponent(
    rows: Int,
    columns: Int,
    tileWidth: Dp,
    tileHeight: Dp,
    tileModifier: Modifier = Modifier
){
    for(row in 0 until rows){
        for(column in 0 until columns){
            Box(
                contentAlignment = Alignment.Center,
                modifier = tileModifier
                    .padding(start = tileWidth * column, top = tileHeight * row)
                    .width(tileWidth)
                    .height(tileHeight)
            ){}
        }
    }
}