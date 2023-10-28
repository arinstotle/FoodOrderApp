package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import com.example.nonameapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun DividerComponent() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
            ,
            color = Color.LightGray,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.or),
            fontFamily = ReemKufi,
            fontSize = 14.sp)
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )

    }
}