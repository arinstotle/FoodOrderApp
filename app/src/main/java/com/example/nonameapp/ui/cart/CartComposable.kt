package com.example.nonameapp.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nonameapp.ui.dishesmenu.FoodDishUIModel
import com.example.nonameapp.viewModels.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    mViewModel: CartViewModel
) {
    val itemsInCart: List<FoodDishUIModel> by mViewModel.dishesInCart.collectAsState()
    val totalSum: Int by mViewModel.totalCartSum.collectAsState()

    Scaffold(
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.75f)
            ){
                LazyColumn(
                    modifier = Modifier
                ) {
                    items(itemsInCart){ foodDish ->
                        TinyDishCardInCart(
//                            mViewModel = mViewModel,
//                            navController = navController,
                            foodDish = foodDish,
                            onRemoveDish = { id ->
                                mViewModel.removeDishFromCart(id)
                            }
                        )
                    }
                }
            }


            // Divider
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            )

            // Row with total sum
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Сумма",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = "$totalSum руб.",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Button "Order now"
            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 40.dp, bottom = 10.dp)
                    .fillMaxWidth()
                    .height(65.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Оформить заказ",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
fun TinyDishCardInCart(
//    mViewModel: CartViewModel,
//    navController: NavController,
    foodDish: FoodDishUIModel,
    onRemoveDish: (foodId: String) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 15.dp)
            .clickable { /*TODO:Click on Dish in the Cart*/ },
        color = MaterialTheme.colorScheme.secondary,
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(110.dp)
                    .padding(start = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = foodDish.image),
                    contentDescription = foodDish.description,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = foodDish.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    IconButton(
                        modifier = Modifier
                            .padding(end = 10.dp),
                        onClick = { onRemoveDish(foodDish.id) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "clear",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = foodDish.price.toString() + " руб.",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }


        }
    }
}

//@Preview
//@Composable
//fun TinyDishCardInCartPreview() {
//    TinyDishCardInCart(
//        foodDish = FoodDishUIModel(
//            id = 0,
//            title = "Borsh",
//            image = R.drawable.borsh,
//            description = "Tasty borsh",
//            price = 300,
//            category = FoodCategories.SOUPS
//        )
//    )
//}