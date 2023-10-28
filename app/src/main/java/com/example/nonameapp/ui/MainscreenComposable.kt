package com.example.nonameapp.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.nonameapp.Feature
import com.example.nonameapp.R
import com.example.nonameapp.util.standardQuadFromTo
import com.example.nonameapp.ui.bottomMenu.*
import com.example.nonameapp.ui.theme.*
import kotlinx.coroutines.delay
import java.lang.Math.sin

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
        .background(Color.Black)
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
                ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Right", "Left", "Memes"))
            }
            CurrentMeditation()
            FeatureSection(
                isLoading = isLoading,
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.arrow_right,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.search_icon,
                        almostTransparentBlack,
                        slightlyDarkerBlack,
                        evenDarkerBlack
                    )
                )
            )

        }
    }
//        BottomMenu(items = listOf(
//            BottomMenuContent("Home", androidx.core.R.drawable.ic_call_answer),
//            BottomMenuContent("Meditate", androidx.core.R.drawable.ic_call_answer),
//            BottomMenuContent("Sleep", androidx.core.R.drawable.ic_call_answer),
//            BottomMenuContent("Music", androidx.core.R.drawable.ic_call_answer),
//            BottomMenuContent("Profile", androidx.core.R.drawable.ic_call_answer),
//        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Preview
@Composable
fun GreetingSection(
    name: String = "John",
    imageResource: Int = R.drawable.food_onboarding
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(
                CardColor,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.sample_avatar),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Text(
                    "Hello, $name!",
                    Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = ReemKufi
                )
                Text(
                    text = "Let's make your healthy goals a reality.",
                    color = Color.Gray,
                    fontFamily = ReemKufi
                )
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.search),
                    contentDescription = "SearchButton",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .background(CardColor, shape = RoundedCornerShape(10.dp))) {
        LazyRow {
            items(chips.size) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedChipIndex = it
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedChipIndex == it) Color.DarkGray
                            else Color.Gray
                        )
                        .padding(15.dp)
                ) {
                    Text(text = chips[it], color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = Color.Blue
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(GrayColorWithAlpha)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        AnimatedWave()
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        AnimatedWave()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun AnimatedWave() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    Wave(animOffset)
}

@Composable
fun Wave(offset: Float) {
    Canvas(
        modifier = Modifier.size(40.dp),
        onDraw = {
            val waveColor = Color.Gray
            val waveStrokeWidth = 2.dp.toPx()
            val width = size.width
            val height = size.height
            val path = androidx.compose.ui.graphics.Path()
            path.moveTo(0f, height / 2f)
            for (x in 0 until width.toInt()) {
                val y = (height / 2f) + sin((x + offset).toDouble() / 20.0) * 10.0
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

@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<Feature>, isLoading : Boolean) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            color = Color.White,
            text = "Hot",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                ShimmerListItem(isLoading = isLoading, contentAfterLoading = {
                    FeatureItem(
                        feature = features[it]
                    )
                })
            }
        }
    }
}

@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if(isLoading) {
        Column(modifier =
        modifier.padding(7.5.dp)
            .aspectRatio(1f)
            .background(Color.Gray, shape = RoundedCornerShape(10.dp))
            .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(26.dp)
                    .padding(8.dp)
                    .shimmerEffect()
                    .align(Alignment.TopStart)
            )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "",
                    tint = Color.Transparent,
                    modifier = Modifier.align(Alignment.BottomStart).shimmerEffect()
                )
                Text(
                    text = "Start",
                    color = Color.Transparent,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                        }
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                        .shimmerEffect()
                )

            }
        }
    } else {
        contentAfterLoading()
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

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = androidx.compose.ui.graphics.Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = androidx.compose.ui.graphics.Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Image(
            painter = painterResource(id = R.drawable.sample_avatar),
            contentDescription = "",
            contentScale = ContentScale.Crop)
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = feature.title,
                style = MaterialTheme.typography.titleMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {


                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Black)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )

        }
    }
}





