package com.example.nonameapp.ui

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nonameapp.OnBoardingData
import com.example.nonameapp.R
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.theme.BottomCardShape
import com.example.nonameapp.ui.theme.FoodOnboardingBackground
import com.example.nonameapp.ui.theme.FoodOnboardingGradient
import com.example.nonameapp.ui.theme.FoodOnboardingText
import com.example.nonameapp.ui.theme.PillsOnboardingBackground
import com.example.nonameapp.ui.theme.PillsOnboardingGradient
import com.example.nonameapp.ui.theme.PillsOnboardingText
import com.example.nonameapp.ui.theme.Poppins
import com.example.nonameapp.ui.theme.WaterOnboardingBackground
import com.example.nonameapp.ui.theme.WaterOnboardingGradient
import com.example.nonameapp.ui.theme.WaterOnboardingText
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, DelicateCoroutinesApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
        Surface(modifier = Modifier.fillMaxSize()) {
            val items = ArrayList<OnBoardingData>()
            items.add(
                OnBoardingData(
                    R.drawable.food_onboarding_sticker,
                    "Healthy Recipes",
                    "Delicious and healthy Food & Calorie Counting",
                    backgroundColor = FoodOnboardingBackground,
                    mainColor = FoodOnboardingText,
                    gradientColor = FoodOnboardingGradient
                )
            )
            items.add(
                OnBoardingData(
                    R.drawable.pills_sticker4,
                    "Pills Tracker",
                    "Now you won't forget to take pills",
                    backgroundColor = PillsOnboardingBackground,
                    mainColor = PillsOnboardingText,
                    gradientColor = PillsOnboardingGradient
                )
            )
            items.add(
                OnBoardingData(
                    R.drawable.water_onboarding_sticker,
                    "Water Tracker",
                    "We understand how important water balance is. And you?",
                    backgroundColor = WaterOnboardingBackground,
                    mainColor = WaterOnboardingText,
                    gradientColor = WaterOnboardingGradient
                )
            )
            val pagerState = rememberPagerState(
                pageCount = items.size,
                initialOffscreenLimit = 2,
                infiniteLoop = false,
                initialPage = 0,
            )
            OnBoardingPager(
                item = items, pagerState = pagerState, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Blue),
                navController
            )

        }
}

@DelicateCoroutinesApi
@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    item[page].mainColor,
                                    Color.Black
                                ),
                                startY = 200f
                            )
                        ),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(id = item[page].image),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = item[page].title,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                shape = BottomCardShape.large
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PagerIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, end = 16.dp),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = Poppins,
                            textAlign = TextAlign.Right,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = item[pagerState.currentPage].desc,
                            modifier = Modifier.padding(16.dp),
                            color = Color.Gray,
                            fontFamily = Poppins,
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraLight
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            val scope = rememberCoroutineScope()
                            if (pagerState.currentPage != 2) {
                                TextButton(onClick = {





                                }) {
                                    Text(
                                        text = "Skip Now",
                                        color = item[pagerState.currentPage].mainColor,
                                        fontFamily = Poppins,
                                        textAlign = TextAlign.Right,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                                OutlinedButton(
                                    onClick = {
                                        scope.launch {
                                            pagerState.scrollToPage(
                                                pagerState.currentPage + 1,
                                                pageOffset = 0f
                                            )
                                        }
                                    },
                                    border = BorderStroke(
                                        14.dp,
                                        item[pagerState.currentPage].mainColor
                                    ),
                                    shape = RoundedCornerShape(50),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = item[pagerState.currentPage].mainColor),
                                    modifier = Modifier.size(65.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.arrow_right),
                                        contentDescription = "",
                                        tint = item[pagerState.currentPage].mainColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            } else {
                                MyButton(navController)
                            }
                        }
                    }
                }
            }

        }
    }
}



@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingData>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage, color = items[it].mainColor)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp, label = "")

    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) color else Color.Gray.copy(alpha = 0.5f)
            )
    )
}

@Composable
fun MyButton(navController: NavController) {
    val buttonBackgroundColor = WaterOnboardingText
    val buttonTextColor = Color.White
    Button(
        onClick = {
            navController.navigate(Screen.AuthorizationScreen.route)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroundColor,
            contentColor = buttonBackgroundColor),
        contentPadding = PaddingValues(vertical = 8.dp),
        elevation = ButtonDefaults.buttonElevation(8.dp)
    ) {
        Text(
            text = "Get Started",
            color = buttonTextColor,
            fontFamily = Poppins,
            fontSize = 16.sp
        )
    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}