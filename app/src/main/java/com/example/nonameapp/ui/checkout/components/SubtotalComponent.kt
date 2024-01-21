package com.example.nonameapp.ui.checkout.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun SubtotalComponent(
    subtotalRub: Int,
    discountRub: Int,
    discountPromoCodeRub: Int,
    totalRub: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        
        // Subtotal
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = stringResource(id = R.string.checkout_subtotal),
                fontSize = 15.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
            )

            Text(
                text = "$subtotalRub ₽",
                fontSize = 15.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
            )
        }

        // Discount
        if(discountRub > 0){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(id = R.string.checkout_discount),
                    fontSize = 15.sp,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )

                Text(
                    text = "-$discountRub ₽",
                    fontSize = 15.sp,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            }
        }

        // Discount Promo Code
        if(discountPromoCodeRub > 0){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(id = R.string.checkout_discount_promo_code),
                    fontSize = 15.sp,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )

                Text(
                    text = "-$discountPromoCodeRub ₽",
                    fontSize = 15.sp,
                    fontFamily = ReemKufi,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            }
        }
        
        // Total
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ){
            Text(
                text = stringResource(id = R.string.checkout_total),
                fontSize = 36.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "$totalRub ₽",
                fontSize = 36.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SubtotalComponentPreview() {
    AppTheme {
        Column {
            SubtotalComponent(
                subtotalRub = 1000,
                discountRub = 150,
                discountPromoCodeRub = 300,
                totalRub = 550
            )
            Divider(modifier = Modifier
                .padding(40.dp)
            )
            SubtotalComponent(
                subtotalRub = 1000,
                discountRub = 0,
                discountPromoCodeRub = 0,
                totalRub = 1000
            )
        }
    }
}