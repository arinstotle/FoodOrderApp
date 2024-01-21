package com.example.nonameapp.ui.checkout.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun BonusComponent(
    bonusCount: Int,
    isChecked: Boolean,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.checkout_bonus_title),
        modifier = modifier,
        fontSize = 20.sp,
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

    Row(
        modifier = Modifier
            .padding(top = 10.dp, end = 20.dp)
            .height(40.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.70f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bonus_svgrepo_com_1),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                tint = Color.Unspecified
            )
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.checkout_bonus_text_first))
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
                        append(" $bonusCount ")

                    }
                    append(stringResource(id = R.string.checkout_bonus_text_last))
                },
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
                text = "Use?",
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
                    .background(if (!isChecked) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primary)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                if (isChecked) {
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun BonusComponentPreview() {
    AppTheme {
        Column {
            BonusComponent(bonusCount = 150, isChecked = true, onClick = {})
            BonusComponent(bonusCount = 50, isChecked = false, onClick = {})
        }
    }
}