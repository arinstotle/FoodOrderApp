package com.example.nonameapp.ui.mainscreen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.nonameapp.R
import com.example.nonameapp.ui.dishesmenu.FoodDishesDataSource
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.FeatureSection
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.GreetingSection
import com.example.nonameapp.ui.mainscreen.tinyComposableElements.TicketComposable
import com.example.nonameapp.ui.theme.*
import com.example.nonameapp.viewModels.MainViewModel
import com.exyte.animatednavbar.utils.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import java.lang.Math.abs
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
    var isLoading by remember {
        mutableStateOf(true)
    }
    var numberDishesInCarte by remember {
        mutableIntStateOf(4)
    }
    var promotions by remember {
        mutableIntStateOf(4)
    }
    val pagerState = rememberPagerState(promotions, 0)
    LaunchedEffect(Unit){
        while (true) {
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    var scrollState by remember { mutableStateOf(ScrollState(0)) }
    LaunchedEffect(key1 = true) {
        delay(10000)
        isLoading = false
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black1_28)
            .verticalScroll(scrollState)
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
                    .background(Black33)
            ) {
                GreetingSection()
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                color = Teal,
                text = "Promotions",
                fontFamily = ReemKufi,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                modifier = Modifier.padding(10.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black1_28),
            ) {
                com.google.accompanist.pager.HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black1_28)
                ) { page ->
                    Box(modifier = Modifier
                        .graphicsLayer {
                            if (!scrollState.canScrollBackward) {
                                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                                lerp(
                                    start = 0.85f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                ).also { scale ->
                                    scaleX = scale
                                    scaleY = scale
                                }
                                alpha = lerp(
                                    start = 0.5f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            }
                        }
                        .fillMaxSize()
                        .background(Black1_28)) {
                            TicketComposable(
                                modifier = Modifier
                                    .padding(16.dp)
                            )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CustomPagerIndicator(pagerState = pagerState)
                }
            }
            FirstBonusesBlock()
            SecondBonusesBlock()
            FeatureSection(
                isLoading = isLoading,
                dishes = FoodDishesDataSource.listOfFoodDishes
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
                Color(0xFF414141),
                Color(0xFF5F5F5F),
                Color(0xFF414141)
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        ),
        RoundedCornerShape(15.dp)
    )
        .onGloballyPositioned {
            size = it.size
        }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomPagerIndicator(pagerState: PagerState,
                         modifier: Modifier = Modifier,
                         indicatorColor: Color = OrangeD8) {
    Row {
        val offsetIntPart = pagerState.currentPageOffset.toInt()
        val offsetFractionalPart = pagerState.currentPageOffset - offsetIntPart
        val currentPage = pagerState.currentPage + offsetIntPart
        val targetPage = if (pagerState.currentPageOffset < 0) currentPage - 1 else currentPage + 1
        val currentPageWidth = baseWidth * (1 + (1 - abs(offsetFractionalPart)) * MULTIPLIER_SELECTED_PAGE)
        val targetPageWidth = baseWidth * (1 + abs(offsetFractionalPart) * MULTIPLIER_SELECTED_PAGE)
        repeat(pagerState.pageCount) { index ->
            val width = when (index) {
                currentPage -> currentPageWidth
                targetPage -> targetPageWidth
                else -> baseWidth
            }
            Box(
                modifier = Modifier
                    .width(width)
                    .clip(CircleShape)
                    .background(indicatorColor)
                    .height(height)
            )
            if (index != pagerState.pageCount - 1) {
                Spacer(modifier = Modifier.width(spacing))
            }
        }
    }
}

private const val MULTIPLIER_SELECTED_PAGE = 4
private val baseWidth = 4.dp
private val spacing = 10.dp
private val height = 8.dp

@Composable
fun FirstBonusesBlock() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 16.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(100.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(10.dp)
        ) {
            Image(modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.bonuses),
                contentDescription = "")
        }
        Spacer(modifier = Modifier.width(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .weight(1f)
                .height(100.dp)
                .padding(10.dp)
                .background(OrangeTransparent, RoundedCornerShape(15.dp))
                .clickable {

                }
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .align(Alignment.Center)
            ) {
                Column(modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
                ) {
                    Text(
                        color = Teal,
                        text = "More bonuses",
                        fontFamily = ReemKufi,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        )
                    Text(
                        color = TextGray,
                        fontFamily = ReemKufi,
                        text = "Enter a promocode",
                        fontSize = 15.sp,
                    )
                }
                Icon(
                    imageVector =
                    ImageVector.vectorResource(id = R.drawable.chevron_right),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .align(Alignment.CenterVertically)
                    ,
                    tint = TextGray
                )
            }
        }
    }
}

@Composable
fun SecondBonusesBlock(userBonuses: String = "50") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(100.dp)
                .background(Black33, RoundedCornerShape(15.dp))
                .padding(10.dp)
        ) {
           Column(modifier = Modifier
               .align(Alignment.Center)) {
               Text(
                   color = Teal,
                   text = "Available",
                   fontFamily = ReemKufi,
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold,
               )
               Row(modifier = Modifier
                   .align(Alignment.CenterHorizontally)
               ) {
                   Text(
                       color = OrangeD8,
                       text = userBonuses,
                       fontFamily = ReemKufi,
                       fontSize = 25.sp,
                       fontWeight = FontWeight.ExtraBold,
                   )
                   Box(modifier = Modifier
                       .padding(start = 8.dp)
                       .align(Alignment.CenterVertically)
                   ) {
                       Text(
                           color = OrangeD8,
                           text = "bonuses",
                           fontFamily = ReemKufi,
                           fontSize = 18.sp,
                           fontWeight = FontWeight.Medium,
                       )
                   }
                   Box(modifier = Modifier
                       .padding(start = 8.dp)
                       .align(Alignment.CenterVertically)
                   ) {
                       Icon(
                           imageVector =
                           ImageVector.vectorResource(id = R.drawable.coins),
                           contentDescription = null,
                           modifier = Modifier
                               .size(34.dp)
                               .align(Alignment.BottomEnd),
                           tint = RedD8
                       )
                   }
               }
           }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(100.dp)
                .background(Black33, RoundedCornerShape(15.dp))
                .padding(10.dp)
        ) {
            Column(modifier = Modifier
                .align(Alignment.Center)) {
                Text(
                    color = Teal,
                    text = "Get bonuses",
                    fontFamily = ReemKufi,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Row(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                ) {
                    Box(modifier = Modifier
                        .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            color = TextGray,
                            text = "for the order",
                            fontFamily = ReemKufi,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Box(modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector =
                            ImageVector.vectorResource(id = R.drawable.scan_code_qr),
                            contentDescription = null,
                            modifier = Modifier
                                .size(34.dp)
                                .align(Alignment.BottomEnd),
                            tint = RedD8
                        )
                    }
                }
            }
        }
    }
}