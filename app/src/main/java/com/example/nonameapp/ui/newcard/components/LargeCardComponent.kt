package com.example.nonameapp.ui.newcard.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun LargeCardComponent(
    holderNameText: String,
    cardNumbersText: String,
    validUntilText: String,
    cvvText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(OrangeD8, RedD8)
                ),
                shape = RoundedCornerShape(15)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 25.dp, bottom = 25.dp)
        ) {
            Text(
                text = holderNameText,
                fontSize = 20.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = cardNumbersText,
                modifier = Modifier
                    .padding(top = 35.dp),
                fontSize = 24.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(fraction = 0.5f),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.4f)
                ) {
                    Text(
                        text = "VALID",
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = validUntilText,
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 30.dp)
                ) {
                    Text(
                        text = "CVV",
                        modifier = Modifier,
                        fontSize = 12.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        text = cvvText,
                        modifier = Modifier,
                        fontSize = 20.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.visa),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 20.dp)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LargeCardComponentPreview() {
    AppTheme {
        Column {
            LargeCardComponent(
                holderNameText = "Samuel Cox",
                cardNumbersText = "4221  ****  ****  9018",
                validUntilText = "10/25",
                cvvText = "***"
            )
        }
    }
}
