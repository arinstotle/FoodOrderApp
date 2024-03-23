package com.example.nonameapp.ui.checkout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.data.model.PaymentCardUIModel
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun PaymentMethodComponent(
    paymentCards: List<PaymentCardUIModel>,
    chosenCardIndex: Int,
    onChangedChosenCard: (newCardIndex: Int) -> Unit,
    onClickAddNewCard: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(id = R.string.checkout_payment_method_title),
            fontSize = 20.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Cards
        for (i in paymentCards.indices) {
            CheckoutPaymentCard(
                cardNumber = paymentCards[i].number,
                checked = chosenCardIndex == i
            ) {
                onChangedChosenCard(i)
            }
        }

        // Add new card
        Row(
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp)
                .height(40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.7f)
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.new_card_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Add new card",
                    modifier = Modifier
                        .padding(start = 15.dp),
                    fontSize = 14.sp,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .clickable { onClickAddNewCard() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )

                }
            }
        }
    }
}

@Composable
private fun CheckoutPaymentCard(
    cardNumber: String,
    checked: Boolean = false,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .padding(top = 20.dp, end = 20.dp)
            .height(40.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.3f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.mastercard_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                tint = Color.Unspecified
            )
            Text(
                text = "Card",
                modifier = Modifier
                    .padding(start = 15.dp),
                fontSize = 14.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = cardNumber,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp),
                fontSize = 14.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(if(!checked) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primary)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ){
                if(checked) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}