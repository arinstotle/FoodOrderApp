package com.example.nonameapp.ui.carte

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.Black14
import com.example.nonameapp.ui.theme.Black1_28
import com.example.nonameapp.ui.theme.DarkRed
import com.example.nonameapp.ui.theme.FoodOnboardingGradient
import com.example.nonameapp.ui.theme.GrayColorWithAlpha
import com.example.nonameapp.ui.theme.almostTransparentBlack
import com.example.nonameapp.ui.theme.evenDarkerBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarteScreen(
    navController: NavController
) {
    val list = FoodDishesDataSource.listOfFoodDishes
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Soups",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO: Navigate to DishScreen*/ }
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
                )
            )
        },
    ) {
        LazyVerticalGrid(
            state = rememberLazyGridState(),
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(it),
            contentPadding = PaddingValues(10.dp)
        ) {
            itemsIndexed(
                items = list,
                key = { _: Int, item: FoodDish ->
                    item.hashCode()
                }
            ) { _, item ->
                TinyFoodDishCard(item)
            }
        }
    }

}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CarteScreenPreview() {
//    CarteScreen()
//}

@Composable
fun TinyFoodDishCard(foodDish: FoodDish) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .padding(10.dp)
            .clickable {
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
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.background,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
                    .padding(start = 15.dp, end = 15.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.5f)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = foodDish.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                    Text(
                        text = foodDish.description,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                    Text(
                        text = foodDish.price.toString() + " руб.",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                            .padding(top = 5.dp)
                    )
                }

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

@Preview(
    showBackground = true,
    widthDp = 200,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun TinyFoodDishCardDayPreview() {
    TinyFoodDishCard(
        foodDish = FoodDish(
            id = 0,
            name = "Borsh",
            image = R.drawable.borsh,
            description = "Tasty borsh",
            price = 300
        )
    )
}

//@Preview(showBackground = true, widthDp = 200, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun TinyFoodDishCardNightPreview() {
//    TinyFoodDishCard(
//        foodDish = FoodDish(
//            id = 0,
//            name = "Borsh",
//            image = R.drawable.borsh,
//            description = "Tasty borsh",
//            price = 300
//        )
//    )
//}