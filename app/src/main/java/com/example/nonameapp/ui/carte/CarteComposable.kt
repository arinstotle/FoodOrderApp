package com.example.nonameapp.ui.carte

import androidx.compose.runtime.saveable.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import android.view.MotionEvent
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.nonameapp.R
import com.example.nonameapp.ui.carte.RatingBarUtils.stepSized
import com.example.nonameapp.ui.theme.FoodOnboardingGradient
import com.example.nonameapp.ui.theme.ReemKufi
import com.example.nonameapp.ui.theme.Shapes
import com.example.nonameapp.util.AppBarCollapsedHeight
import com.example.nonameapp.util.AppBarExpendedHeight
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.example.nonameapp.ui.cart.CartScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarteScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()

    val dishSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val cartSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showDishBottomSheet by remember { mutableStateOf(false) }
    var showCartBottomSheet by remember { mutableStateOf(false) }

    val list = FoodDishesDataSource.listOfFoodDishes
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Soups",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO: Navigate to %screen%*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = FoodOnboardingGradient
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Cart") },
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "") },
                onClick = {
                    showCartBottomSheet = true
                },
                backgroundColor = MaterialTheme.colorScheme.primary
            )
        }
    ) {
        if (showDishBottomSheet || showCartBottomSheet) {
            ModalBottomSheet(
                shape = RoundedCornerShape(4.dp),
                containerColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize(),
                onDismissRequest = {
                    if(showDishBottomSheet)
                        showDishBottomSheet = false
                    else
                        showCartBottomSheet = false
                },
                sheetState = if(showDishBottomSheet) dishSheetState else cartSheetState,
                content = {
                    scope.launch {
                        if(showDishBottomSheet)
                            dishSheetState.expand()
                        else
                            cartSheetState.expand()
                    }

                    if(showDishBottomSheet)
                        DishCardInfoComposable(foodDish = FoodDishesDataSource.listOfFoodDishes[0])
                    else
                        CartScreen(navController = navController)
                }
            )
        }

        LazyVerticalGrid(
            state = rememberLazyGridState(),
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(it),
            contentPadding = PaddingValues(10.dp)
        ) {
            itemsIndexed(
                items = list,
                key = { _: Int, item: FoodDishUIModel ->
                    item.hashCode()
                }
            ) { _, item ->
                TinyFoodDishCard(item){
                    showDishBottomSheet = true
                }
            }
        }
    }

}

@Composable
fun TinyFoodDishCard(
    foodDish: FoodDishUIModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .padding(10.dp)
            .clickable {
                onClick()
            }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.75f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = foodDish.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    text = foodDish.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    text = foodDish.price.toString() + " руб.",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }

        }
        Image(
            painter = painterResource(id = foodDish.image),
            contentDescription = foodDish.description,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .shadow(
                    elevation = 5.dp,
                    shape = CircleShape,
                    clip = false
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishCardInfoComposable(foodDish: FoodDishUIModel) {
    val scrollState = rememberLazyListState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        containerColor = Color.White,
        topBar = {
            ParallaxToolbar(foodDish = foodDish, scrollState = scrollState)
        }
    ) { contentPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(contentPadding)) {
            DishContent(foodDish, scrollState)
        }
    }
}

@Preview
@Composable
fun DishCardInfoComposablePreview() {
    DishCardInfoComposable(foodDish =
    FoodDishesDataSource.listOfFoodDishes[0])
}

@Composable
fun DishContent(foodDish: FoodDishUIModel, scrollState: LazyListState) {
    LazyColumn(
      state = scrollState
    ) {
        item {
            BasicInfo(foodDish)
            Description(foodDish)
            ServingCalculator()
            Spacer(modifier = Modifier.size(16.dp))
            CustomRatingBarView()
            IngredientsSection()
            IngredientList(foodDish)
            AddToCartButton()
            ReviewsSection(foodDish)
        }
    }
}

@Composable
fun ReviewsSection(foodDish: FoodDishUIModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Reviews",
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Bold)
            Text(text = foodDish.reviews,
                fontFamily = ReemKufi,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold)
        }
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Red
            ),
            elevation = null) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier.padding(8.dp), text = "See all", fontFamily = ReemKufi)
                Icon(modifier = Modifier.padding(8.dp), painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = null)
            }
        }
    }
}

@Composable
fun AddToCartButton() {
    Button(onClick = { /*TODO*/ },
        elevation = null,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ), 
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(text = "Add to cart", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun <T> ElementsGrid(columnsCount : Int,
                     items : List<T>,
                     content : @Composable (T) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        for (i in items.indices step columnsCount) {
            Row {
                for (j in 0 until columnsCount) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun IngredientList(foodDish: FoodDishUIModel) {
    ElementsGrid(columnsCount = 3, items = foodDish.ingredients) {
        IngredientCard(ingredient = it)
    }
}

@Composable
fun IngredientCard(ingredient: Ingredient) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp),
            elevation = CardDefaults.elevatedCardElevation(0.dp)
        ) {
            Image(
                painter = painterResource(id = ingredient.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
        Text(
            text = ingredient.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = ReemKufi
        )
        Text(
            text = ingredient.title,
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            fontFamily = ReemKufi
        )
    }
}

@Composable
fun CustomRatingBarView() {
    RatingBarView()
}

@Composable
fun IngredientsSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .clip(Shapes.medium)
            .background(Color.LightGray)
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Ingredients:",
            fontFamily = ReemKufi,
            fontSize = 16.sp,
            modifier = Modifier,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ServingCalculator() {
    var counter by remember {
        mutableStateOf(0)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .clip(Shapes.medium)
            .background(Color.LightGray)
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Serving",
            fontFamily = ReemKufi,
            modifier = Modifier
                .weight(1f),
            fontWeight = FontWeight.Medium)
        CircularButton(iconResource = R.drawable.minus_icon,
            elevation = null,
            color = Color.Red) {
            if (counter > 0)
                counter--
        }
        Text(text = "$counter",
            modifier = Modifier
                .padding(16.dp),
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Medium)
        CircularButton(iconResource = R.drawable.plus_icon,
            elevation = null,
            color = Color.Red) {
            counter++
        }
    }
}

@Composable
fun Description(foodDish: FoodDishUIModel) {
    Text(text = foodDish.description,
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(horizontal = 16.dp,
            vertical = 16.dp)
    )
}

@Composable
fun BasicInfo(foodDish: FoodDishUIModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.search_icon, foodDish.cookingTime)
        InfoColumn(R.drawable.search_icon, foodDish.calories)
        InfoColumn(R.drawable.search_icon, foodDish.rating)
    }
}

@Composable
fun InfoColumn(
    @DrawableRes
    painResource : Int,
    text : String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = painResource),
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.height(24.dp)
        )
        Text(text = text,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ParallaxToolbar(foodDish: FoodDishUIModel, scrollState: LazyListState) {
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight
    val maxOffset = with(LocalDensity.current) { imageHeight.roundToPx() } - 700
    val offset = kotlin.math.min(scrollState.firstVisibleItemScrollOffset, maxOffset)
    val offsetProgress = kotlin.math.max(0f, offset * 3f - 2f + maxOffset) / maxOffset
    androidx.compose.material.TopAppBar(
        contentPadding = PaddingValues(0.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(AppBarExpendedHeight)
            .padding(0.dp),
        elevation = if (offset == maxOffset) 4.dp else 0.dp,
    ) {
        Column {
            Box(modifier = Modifier.height(imageHeight)) {
                Image(
                    painter = painterResource(id = R.drawable.cupcake),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.4f, Color.Transparent),
                                    Pair(1f, Color.White)
                                )
                            )
                        )
                )
                Row(modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = foodDish.category.name,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .clip(Shapes.small)
                            .background(Color.Red)
                            .padding(vertical = 6.dp, horizontal = 16.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                text = foodDish.title,
                fontSize = 26.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = foodDish.title,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        CircularButton(R.drawable.search_icon)
        CircularButton(R.drawable.search_icon)
    }
}

@Composable
fun CircularButton(
    @DrawableRes
    iconResource : Int,
    color: Color = Color.Gray,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    onClick : () -> Unit = {}
) {
    Button(onClick = { /*TODO*/ },
        contentPadding = PaddingValues(),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = color
        ),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResource), null)
    }
}
@Composable
fun RatingBarView() {
    var rating by rememberSaveable { mutableStateOf(0.0f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomRatingBar(
            value = rating,
            onValueChange = {
                rating = it
            },
            onRatingChanged = {

            },
            config = RatingBarConfig()
                .style(RatingBarStyle.HighLighted)
        )
    }
}

sealed class StepSize {
    object ONE : StepSize()
}

sealed class RatingBarStyle {
    object Normal : RatingBarStyle()
    object HighLighted : RatingBarStyle()
}

val StarRatingKey = SemanticsPropertyKey<Float>("StarRating")
var SemanticsPropertyReceiver.starRating by StarRatingKey

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomRatingBar(
    value: Float,
    modifier: Modifier = Modifier,
    config: RatingBarConfig = RatingBarConfig(),
    onValueChange: (Float) -> Unit,
    onRatingChanged: (Float) -> Unit
) {
    var rowSize by remember { mutableStateOf(Size.Zero) }
    var lastDraggedValue by remember { mutableStateOf(0f) }
    val direction = LocalLayoutDirection.current

    Row(modifier = modifier
        .onSizeChanged { rowSize = it.toSize() }
        .pointerInput(
            Unit
        ) {
            detectHorizontalDragGestures(
                onDragEnd = {
                    if (config.isIndicator || config.hideInactiveStars)
                        return@detectHorizontalDragGestures
                    onRatingChanged(lastDraggedValue)
                },
                onDragCancel = {},
                onDragStart = {},
                onHorizontalDrag = { change, _ ->
                    if (config.isIndicator || config.hideInactiveStars)
                        return@detectHorizontalDragGestures
                    change.consumeAllChanges()
                    val x1 = change.position.x.coerceIn(0f, rowSize.width)
                    val calculatedStars =
                        RatingBarUtils.calculateStars(
                            x1,
                            rowSize.width,
                            config.numStars,
                            config.padding.value.toInt()
                        )
                    var newValue =
                        calculatedStars
                            .stepSized(config.stepSize)
                            .coerceIn(0f, config.numStars.toFloat())

                    if (direction == LayoutDirection.Rtl)
                        newValue = config.numStars - newValue
                    onValueChange(newValue)
                    lastDraggedValue = newValue
                }
            )
        }
        .pointerInteropFilter {
            if (config.isIndicator || config.hideInactiveStars)
                return@pointerInteropFilter false
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {

                    val calculatedStars =
                        RatingBarUtils.calculateStars(
                            it.x,
                            rowSize.width,
                            config.numStars,
                            config.padding.value.toInt()
                        )
                    var newValue =
                        calculatedStars
                            .stepSized(config.stepSize)
                            .coerceIn(0f, config.numStars.toFloat())
                    if (direction == LayoutDirection.Rtl)
                        newValue = config.numStars - newValue
                    onValueChange(newValue)
                    onRatingChanged(newValue)
                }
            }
            true
        }) {
        ComposeStars(value, config)
    }
}

@Composable
fun ComposeStars(
    value: Float,
    config: RatingBarConfig
) {

    val ratingPerStar = 1f
    var remainingRating = value

    Row(modifier = Modifier
        .semantics { starRating = value }) {
        for (i in 1..config.numStars) {
            val starRating = when {
                remainingRating == 0f -> {
                    0f
                }
                remainingRating >= ratingPerStar -> {
                    remainingRating -= ratingPerStar
                    1f
                }
                else -> {
                    val fraction = remainingRating / ratingPerStar
                    remainingRating = 0f
                    fraction
                }
            }
            if (config.hideInactiveStars && starRating == 0.0f)
                break
            RatingStar(
                fraction = starRating,
                config = config,
                modifier = Modifier
                    .padding(
                        start = if (i > 1) config.padding else 0.dp,
                        end = if (i < config.numStars) config.padding else 0.dp
                    )
                    .size(size = config.size)
                    .testTag("RatingStar")
            )
        }
    }
}
@Stable
class FractionalRectangleShape(
    @FloatRange(from = 0.0, to = 1.0) private val startFraction: Float,
    @FloatRange(from = 0.0, to = 1.0) private val endFraction: Float
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                left = (startFraction * size.width).coerceAtMost(size.width - 1f),
                top = 0f,
                right = (endFraction * size.width).coerceAtLeast(1f),
                bottom = size.height
            )
        )
    }
}

fun Path.addStar(
    size: Size,
    spikes: Int = 5,
    @FloatRange(from = 0.0, to = 0.5) outerRadiusFraction: Float = 0.5f,
    @FloatRange(from = 0.0, to = 0.5) innerRadiusFraction: Float = 0.2f
): Path {
    val outRadius = size.minDimension * outerRadiusFraction
    val innerRadius = size.minDimension * innerRadiusFraction
    val centerX = size.width / 2
    val centerY = size.height / 2
    var totalAngle = PI / 2
    val degreesPerSection = (2 * PI) / spikes

    moveTo(centerX, 0f)

    var x: Double
    var y: Double

    for (i in 1..spikes) {
        totalAngle += degreesPerSection / 2
        x = centerX + cos(totalAngle) * innerRadius
        y = centerY - sin(totalAngle) * innerRadius
        lineTo(x.toFloat(), y.toFloat())

        totalAngle += degreesPerSection / 2
        x = centerX + cos(totalAngle) * outRadius
        y = centerY - sin(totalAngle) * outRadius
        lineTo(x.toFloat(), y.toFloat())
    }

    close()
    return this
}

class RatingBarConfig {
    var size: Dp = 50.dp
        private set
    var padding: Dp = 2.dp
        private set
    var style: RatingBarStyle = RatingBarStyle.Normal
        private set
    var numStars: Int = 5
        private set
    var isIndicator: Boolean = false
        private set
    var activeColor: Color = Color.Red
        private set
    var inactiveColor: Color = Color.Red.copy(alpha = 0.5f)
        private set
    var stepSize: StepSize = StepSize.ONE
        private set
    var hideInactiveStars: Boolean = false
        private set
    fun style(value: RatingBarStyle): RatingBarConfig =
        apply { style = value }
}

object RatingBarUtils {
    fun calculateStars(
        draggedWidth: Float,
        width: Float,
        numStars: Int,
        padding: Int
    ): Float {
        var overAllComposeWidth = width
        val spacerWidth = numStars * (2 * padding)
        overAllComposeWidth -= spacerWidth
        return if (draggedWidth != 0f) ((draggedWidth / overAllComposeWidth) * numStars) else 0f
    }

    fun Float.stepSized(stepSize: StepSize): Float {
        return if (stepSize is StepSize.ONE)
            this.roundToInt().toFloat()
        else {
            var value = this.toInt().toFloat()
            if (this < value.plus(0.5)) {
                if (this == 0f)
                    return 0f
                value = value.plus(0.5).toFloat()
                value
            } else {
                this.roundToInt().toFloat()
            }
        }
    }
}

private const val strokeWidth = 1f

@Composable
fun RatingStar(
    @FloatRange(from = 0.0, to = 1.0) fraction: Float,
    config: RatingBarConfig,
    modifier: Modifier = Modifier,
) {
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    Box(modifier = modifier) {
        FilledStar(fraction, config.activeColor, isRtl)
        EmptyStar(fraction, config, isRtl)
    }
}

@Composable
private fun FilledStar(fraction: Float, activeColor: Color, isRtl: Boolean) = Canvas(
    modifier = Modifier
        .fillMaxSize()
        .clip(
            if (isRtl)
                rtlFilledStarFractionalShape(fraction = fraction)
            else
                FractionalRectangleShape(0f, fraction)
        )
) {
    val path = Path().addStar(size)

    drawPath(path, color = activeColor, style = Fill)
    drawPath(path, color = activeColor, style = Stroke(width = strokeWidth))
}

@Composable
private fun EmptyStar(
    fraction: Float,
    config: RatingBarConfig,
    isRtl: Boolean
) = Canvas(
    modifier = Modifier
        .fillMaxSize()
        .clip(
            if (isRtl)
                rtlEmptyStarFractionalShape(fraction = fraction)
            else
                FractionalRectangleShape(fraction, 1f)
        )
) {
    val path = Path().addStar(size)
    if (config.style is RatingBarStyle.Normal)
        drawPath(path, color = config.inactiveColor, style = Fill)
    else
        drawPath(path, color = Color.Gray, style = Stroke(width = strokeWidth))
}

fun rtlEmptyStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 1f || fraction == 0f)
        FractionalRectangleShape(fraction, 1f)
    else FractionalRectangleShape(0f, 1f - fraction)
}

fun rtlFilledStarFractionalShape(fraction: Float): FractionalRectangleShape {
    return if (fraction == 0f || fraction == 1f)
        FractionalRectangleShape(0f, fraction)
    else FractionalRectangleShape(1f - fraction, 1f)
}