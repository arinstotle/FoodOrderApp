package com.example.nonameapp.ui.checkout.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun PromoCodeComponent(
    onApply: (promoCode: String) -> Boolean,
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    var isSuccess by remember { mutableStateOf(false) }
    var isSupportTextShown by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.checkout_promo_code_title),
            fontSize = 20.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                    isSupportTextShown = false
                },
                placeholder = {
                    Text(
                        text = "Enter a promo code...",
                        fontSize = 15.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                    )
                },
                supportingText = {
                    if(isSupportTextShown){
                        Text(
                            text = if(isSuccess)
                                stringResource(id = R.string.checkout_promo_code_success)
                            else
                                stringResource(id = R.string.checkout_promo_code_failure),
                            fontSize = 15.sp,
                            fontFamily = ReemKufi,
                            fontWeight = FontWeight.Medium,
                            color = if(isSuccess) Color.Green else Color.Red
                        )
                    }
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.coupon_svgrepo_com_1),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Unspecified,
                    focusedContainerColor = Color.Unspecified,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .padding(end = 20.dp)
            )

            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .clickable {
                        isSuccess = onApply(text)
                        isSupportTextShown = true
                        text = ""
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.checkout_promo_code_apply),
                    fontSize = 16.sp,
                    fontFamily = ReemKufi,
                    maxLines = 1,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PromoCodePreview() {
    AppTheme {
        Column {
            PromoCodeComponent(
                onApply = { true }
            )
        }
    }
}