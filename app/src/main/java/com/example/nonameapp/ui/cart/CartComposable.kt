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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nonameapp.FoodCategories
import com.example.nonameapp.R
import com.example.nonameapp.ui.carte.FoodDishUIModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    mViewModel: CartViewModel = CartViewModel()
) {
    var itemsInCart: List<FoodDishUIModel> by remember { mutableStateOf(mViewModel.getItemsInCart()) }
    var totalSum: Int by remember { mutableIntStateOf(mViewModel.getTotalCartSum()) }
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
                    text = mViewModel.getTotalCartSum().toString() + " руб.",
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

//@Preview(showSystemUi = true)
//@Composable
//fun CartScreenPreview(){
//    CartScreen()
//}

@Composable
fun TinyDishCardInCart(
//    mViewModel: CartViewModel,
//    navController: NavController,
    foodDish: FoodDishUIModel
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
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
                    .width(110.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = foodDish.image),
                    contentDescription = foodDish.description,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp, bottom = 10.dp, end = 5.dp)
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
                        onClick = { /*TODO:Remove Dish from cart*/ }
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