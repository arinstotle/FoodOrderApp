package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FeatureTile(feature: FeaturePicture) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .background(color = Color.White),
    ) {
        Image(
            painter = painterResource(id = feature.iconResource),
            contentDescription = feature.contentDescription,
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, Color.White),
                    startY = 0f,
                    endY = 1f
                )
            ),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun FeatureListComponent(
    list: List<FeaturePicture>,
    modifier: Modifier,
) {
    var itemsListState by remember { mutableStateOf(list) }
    val lazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        modifier = modifier,
    ) {
        items(itemsListState.size) {
            FeatureTile(feature = list[it])

            if (list[it] == itemsListState.last()) {
                val currentList = itemsListState

                val secondPart = currentList.subList(0, lazyListState.firstVisibleItemIndex)
                val firstPart = currentList.subList(lazyListState.firstVisibleItemIndex, currentList.size)

                rememberCoroutineScope().launch {
                    lazyListState.scrollToItem(0,lazyListState.firstVisibleItemScrollOffset - SCROLL_DX.toInt())
                }

                itemsListState = firstPart + secondPart
            }
        }
    }
    LaunchedEffect(Unit) {
        autoScroll(lazyListState)
    }
}

private tailrec suspend fun autoScroll(lazyListState: LazyListState) {
    lazyListState.scroll(MutatePriority.PreventUserInput) {
        scrollBy(SCROLL_DX)
    }
    delay(DELAY_BETWEEN_SCROLL_MS)

    autoScroll(lazyListState)
}

private const val DELAY_BETWEEN_SCROLL_MS = 8L
private const val SCROLL_DX = 1f