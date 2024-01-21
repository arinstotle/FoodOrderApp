package com.example.nonameapp.ui.checkout.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.cart.CartDishUIModel
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun CartComponent(
    dishesList: List<CartDishUIModel>,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.checkout_cart_title),
            fontSize = 20.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            itemsIndexed(items = dishesList) { index, cartDish ->
                CheckoutTinyDish(cartDish = cartDish)
                Spacer(
                    modifier = Modifier
                        .width(20.dp)
                )
            }
        }
    }
}