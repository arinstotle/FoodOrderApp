package com.example.nonameapp.ui.mainscreen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.nonameapp.Feature
import com.example.nonameapp.Promotion
import com.example.nonameapp.R
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.ChipSection
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.FeatureSection
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.GreetingSection
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.PromotionListComponent
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.TicketComposable
import com.example.nonameapp.ui.theme.*
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController) {
    var isLoading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = true) {
        delay(10000)
        isLoading = false
    }
    Box(  modifier = Modifier
        .fillMaxSize()
        .background(Black1_28)
        .verticalScroll(ScrollState(0))
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(Color.White)
            ) {
                GreetingSection()
                ChipSection(chips = listOf(
                    com.example.nonameapp.Chip(
                        "Snacks",
                        R.drawable.chip_snacks),
                    com.example.nonameapp.Chip(
                        "Salads",
                        R.drawable.chip_salad),
                    com.example.nonameapp.Chip(
                        "Soups",
                        R.drawable.chip_soup),
                    com.example.nonameapp.Chip(
                        "Roman pizza",
                        R.drawable.chip_pizza),
                    com.example.nonameapp.Chip(
                        "Josper",
                        R.drawable.chip_pizza),
                    com.example.nonameapp.Chip(
                        "Other",
                        R.drawable.chip_pizza),
                    com.example.nonameapp.Chip(
                        "Prime",
                        R.drawable.chip_pizza),
                    com.example.nonameapp.Chip(
                        "Burgers",
                        R.drawable.chip_burger),
                    com.example.nonameapp.Chip(
                        "Side dishes",
                        R.drawable.chip_sd),
                    com.example.nonameapp.Chip(
                        "Sauces",
                        R.drawable.chip_sauce),
                    com.example.nonameapp.Chip(
                        "Desserts",
                        R.drawable.chip_dessert),
                    com.example.nonameapp.Chip(
                        "Drinks",
                        R.drawable.chip_drink),
                    com.example.nonameapp.Chip(
                        "Alcohol",
                        R.drawable.chip_alco)
                ))
            }
            val promotions = listOf(
                Promotion(
                    promotionTitle = "Promotion 1bcffcbbcfcbfcbf",
                    shortDescription = "Description 1vbvcfbcfncfbfnfncfn",
                    fullDescription = "",
                    fullTitle = "",
                    pictureId = R.drawable.sample_avatar
                ),
                Promotion(
                    promotionTitle = "Promotion 2",
                    shortDescription = "Description 2",
                    fullDescription = "",
                    fullTitle = "",
                    pictureId = R.drawable.sample_avatar
                ),
                Promotion(
                    promotionTitle = "Promotion 3",
                    shortDescription = "Description 3",
                    fullDescription = "",
                    fullTitle = "",
                    pictureId = R.drawable.sample_avatar
                )
            )
            PromotionListComponent(promotions = promotions)
            Box(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Transparent),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TicketComposable(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)
                    )
                    TicketComposable(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Information Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }
            FeatureSection(
                isLoading = isLoading,
                features = listOf(
                    Feature(
                        title = "Dish1",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Dish2",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Dish3",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Dish4",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    )
                )
            )
        }
    }
    }
}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ), label = ""
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}