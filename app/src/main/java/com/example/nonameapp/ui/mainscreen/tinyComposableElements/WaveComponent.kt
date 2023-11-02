package com.example.nonameapp.ui.mainscreen.tinyComposableElements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Wave(offset: Float) {
    Canvas(
        modifier = Modifier.size(40.dp),
        onDraw = {
            val waveColor = Color.Gray
            val waveStrokeWidth = 2.dp.toPx()
            val width = size.width
            val height = size.height
            val path = Path()
            path.moveTo(0f, height / 2f)
            for (x in 0 until width.toInt()) {
                val y = (height / 2f) + Math.sin((x + offset).toDouble() / 20.0) * 10.0
                path.lineTo(x.toFloat(), y.toFloat())
            }
            drawPath(
                path = path,
                color = waveColor,
                style = Stroke(width = waveStrokeWidth)
            )
        }
    )
}