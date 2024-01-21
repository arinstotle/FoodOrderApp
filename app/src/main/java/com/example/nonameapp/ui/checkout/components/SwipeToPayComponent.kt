package com.example.nonameapp.ui.checkout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeProgress
import androidx.compose.material.SwipeableState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.ReemKufi
import kotlin.math.roundToInt

private enum class Anchor { Start, End }

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SlideToPay(
    isCardChosen: Boolean,
    isLoading: Boolean,
    onUnlockRequested: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hapticFeedback = LocalHapticFeedback.current
    val swipeState = rememberSwipeableState(
        initialValue = if (isLoading) Anchor.End else Anchor.Start,
        confirmStateChange = { anchor ->
            if (anchor == Anchor.End) {
                hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                onUnlockRequested()
            }
            true
        }
    )

    val swipeFraction by remember {
        derivedStateOf { calculateSwipeFraction(swipeState.progress) }
    }

    LaunchedEffect(isLoading) {
        swipeState.animateTo(if (isLoading) Anchor.End else Anchor.Start)
    }

    Track(
        swipeState = swipeState,
        swipeFraction = swipeFraction,
        enabled = !isLoading && isCardChosen,
        modifier = modifier,
    ) {
        Hint(
            isCardChosen = isCardChosen,
            swipeFraction = swipeFraction,
            modifier = Modifier
                .align(Alignment.Center)
        )
        if(isCardChosen) {
            Thumb(
                isLoading = isLoading,
                modifier = Modifier.offset {
                    IntOffset(swipeState.offset.value.roundToInt(), 0)
                },
            )
        }
    }
}

@Composable
private fun Thumb(
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .background(color = MaterialTheme.colorScheme.background, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = 2.dp
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.mastercard_icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Preview()
@Composable
private fun ThumbPreview() {
    AppTheme {
        Column {
            Thumb(isLoading = true)
            Thumb(isLoading = false)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Track(
    swipeState: SwipeableState<Anchor>,
    swipeFraction: Float,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit),
) {
    val horizontalPadding = 20.dp
    val thumbSize = 48.dp
    val velocityThreshold = 200.dp

    val density = LocalDensity.current
    var fullWidth by remember { mutableStateOf(0) }

    val startOfTrackPx = 0f
    val endOfTrackPx = remember(fullWidth) {
        with(density) {
            fullWidth - (2 * horizontalPadding + thumbSize).toPx()
        }
    }

    val snapThreshold = 0.8f
    val thresholds = { from: Anchor, _: Anchor ->
        if (from == Anchor.Start) {
            FractionalThreshold(snapThreshold)
        } else {
            FractionalThreshold(1f - snapThreshold)
        }
    }

    val initialColor = MaterialTheme.colorScheme.surface
    val endColor = MaterialTheme.colorScheme.primary
    val backgroundColor by remember(swipeFraction) {
        derivedStateOf {
            calculateTrackColor(
                initialColor = initialColor,
                endColor = endColor,
                swipeFraction = swipeFraction
            )
        }
    }

    Box(
        modifier = modifier
            .onSizeChanged { fullWidth = it.width }
            .height(64.dp)
            .fillMaxWidth()
            .swipeable(
                enabled = enabled,
                state = swipeState,
                orientation = Orientation.Horizontal,
                anchors = mapOf(
                    startOfTrackPx to Anchor.Start,
                    endOfTrackPx to Anchor.End,
                ),
                thresholds = thresholds,
                velocityThreshold = velocityThreshold,
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(percent = 50),
            )
            .padding(
                PaddingValues(
                    horizontal = horizontalPadding,
                    vertical = 8.dp,
                )
            ),
        content = content,
    )
}

@Composable
private fun Hint(
    isCardChosen: Boolean,
    swipeFraction: Float,
    modifier: Modifier = Modifier,
) {
    val hintTextColor by remember(swipeFraction) {
        derivedStateOf { calculateHintTextColor(swipeFraction) }
    }

    Text(
        text = if(isCardChosen)
            stringResource(id = R.string.checkout_swipe_to_pay)
        else
            stringResource(id = R.string.checkout_choose_card),
        fontSize = 20.sp,
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Bold,
        color = if(isCardChosen) hintTextColor else hintTextColor.copy(alpha = 0.5f),
        modifier = modifier
    )
}

private fun calculateHintTextColor(swipeFraction: Float): Color {
    val endOfFadeFraction = 0.35f
    val fraction = (swipeFraction / endOfFadeFraction).coerceIn(0f..1f)
    return lerp(Color.White, Color.White.copy(alpha = 0f), fraction)
}

private fun calculateTrackColor(initialColor: Color, endColor: Color, swipeFraction: Float): Color {
    val endOfColorChangeFraction = 0.4f
    val fraction = (swipeFraction / endOfColorChangeFraction).coerceIn(0f..1f)
    return lerp(initialColor, endColor, fraction)
}

@OptIn(ExperimentalMaterialApi::class)
private fun calculateSwipeFraction(progress: SwipeProgress<Anchor>): Float {
    val atAnchor = progress.from == progress.to
    val fromStart = progress.from == Anchor.Start

    return if (atAnchor) {
        if (fromStart) 0f else 1f
    } else {
        if (fromStart) progress.fraction else 1f - progress.fraction
    }
}
