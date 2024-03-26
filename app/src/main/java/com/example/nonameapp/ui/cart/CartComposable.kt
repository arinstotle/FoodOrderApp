package com.example.nonameapp.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.nonameapp.R
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.navigation.NavigationRouter
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.CustomTopAppBarComposable
import com.example.nonameapp.ui.cart.components.TinyCartDish
import com.example.nonameapp.ui.theme.ReemKufi
import com.example.nonameapp.viewModels.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    mViewModel: CartViewModel
) {
    val itemsInCart: List<CartDishUIModel> by mViewModel.dishesInCart.collectAsState()

    Scaffold(
        topBar = {
            CustomTopAppBarComposable(
                titleText = stringResource(id = R.string.cart_top_bar_title),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                isHaveNavIcon = true,
                onNavIconClick = {
                    navController.popBackStack()
                    NavigationRouter.currentScreen.value = Screen.DishesMenuScreen
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
//                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.75f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                ) {
                    items(itemsInCart, key = { it.id }) { cartDishUIModel ->
                        if (cartDishUIModel.quantity > 0) {
                            TinyCartDish(
                                cartDish = cartDishUIModel,
                                onPlusClick = {
                                    mViewModel.performIncreaseDishQuantity(cartDishUIModel = cartDishUIModel)
                                },
                                onMinusClick = {
                                    mViewModel.performDecreaseDishQuantity(cartDishUIModel = cartDishUIModel)
                                }
                            )
                        }
                    }
                }
            }


            // Divider
            Divider(
                color = MaterialTheme.colorScheme.primary,
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
                    text = stringResource(id = R.string.cart_total),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = ReemKufi,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = "//TODO ₽", //TODO
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // Button "Checkout"
            Button(
                onClick = {
                    navController.navigate(Screen.CheckoutScreen.route)
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
                    text = stringResource(id = R.string.cart_checkout),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

