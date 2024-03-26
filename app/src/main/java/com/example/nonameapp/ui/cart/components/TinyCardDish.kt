package com.example.nonameapp.ui.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.SubcomposeAsyncImage
import com.example.nonameapp.R
import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.network.api.ApiRoutes
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun TinyCartDish(
    cartDish: CartDishUIModel,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit
) {
    var quantity by remember { mutableIntStateOf(cartDish.quantity) }

    Surface(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SubcomposeAsyncImage(
                model = ApiRoutes.BASE_URL + ApiRoutes.FILES_DIRECTORY + cartDish.imageSource,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp))
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .height(110.dp)
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                // Dish's info
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 15.dp),
                ) {
                    Column() {
                        Text(
                            text = cartDish.name,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = ReemKufi,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                        Text(
                            text = "${cartDish.price} ${stringResource(id = R.string.cart_grams)}",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Normal,
                        )
                    }

                    Row() {
                        Text(
                            text = "${cartDish.price} ₽",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.ExtraBold,
                        )

                        Text(
                            text = "x$quantity",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }

                }

                // Plus&Minus buttons
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, end = 15.dp)
                        .fillMaxHeight()
                ) {
                    Box(
                        modifier = Modifier
                            .weight(0.4f)
                            .width(40.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                            )
                            .clickable {
                                quantity++
                                onPlusClick()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.plus_icon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(16.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.4f)
                            .width(40.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                            )
                            .clickable {
                                quantity--
                                onMinusClick()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.minus_icon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(16.dp)
                        )
                    }
                }
            }
        }
    }
}