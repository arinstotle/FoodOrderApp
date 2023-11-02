package com.example.nonameapp.ui.mainscreen.tinyComposableElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nonameapp.Chip
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.CardColor
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun ChipSection(
    chips: List<Chip>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(CardColor, shape = RoundedCornerShape(10.dp))
    ) {
        LazyRow {
            items(chips.size) {
                Column (
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            selectedChipIndex = it
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedChipIndex == it) Color.DarkGray
                            else Color.Gray
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = chips[it].iconId),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
                            .size(35.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                        text = chips[it].chipName,
                        fontFamily = ReemKufi,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ChipSectionPreview() {
    ChipSection(chips = listOf(
        com.example.nonameapp.Chip(
            "Snacks",
            R.drawable.chip_snacks),
        com.example.nonameapp.Chip(
            "Salads",
            R.drawable.chip_salad),
        com.example.nonameapp.Chip(
            "Soups",
            R.drawable.chip_soup),
        com.example.nonameapp.Chip(
            "Roman pizza",
            R.drawable.chip_pizza),
        com.example.nonameapp.Chip(
            "Josper",
            R.drawable.chip_pizza),
        com.example.nonameapp.Chip(
            "Other",
            R.drawable.chip_pizza),
        com.example.nonameapp.Chip(
            "Prime",
            R.drawable.chip_pizza),
        com.example.nonameapp.Chip(
            "Burgers",
            R.drawable.chip_burger),
        com.example.nonameapp.Chip(
            "Side dishes",
            R.drawable.chip_sd),
        com.example.nonameapp.Chip(
            "Sauces",
            R.drawable.chip_sauce),
        com.example.nonameapp.Chip(
            "Desserts",
            R.drawable.chip_dessert),
        com.example.nonameapp.Chip(
            "Drinks",
            R.drawable.chip_drink),
        com.example.nonameapp.Chip(
            "Alcohol",
            R.drawable.chip_alco)
    ))
}