package com.example.nonameapp.ui.mainscreen.tinyComposableElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nonameapp.Chip
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.Black33
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun ChipSection(
    chips: List<Chip>,
    paddingOut: PaddingValues = PaddingValues(0.dp),
    paddingIn: PaddingValues = PaddingValues(0.dp),
    state: LazyListState = rememberLazyListState(),
    selectedChipIndex: Int = 0,
    onChipClick: (newSelectedIndex: Int) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(paddingOut)
            .fillMaxWidth()
            .padding(paddingIn)
    ) {
        LazyRow(
            state = state
        ) {
            items(chips.size) { index ->
                CategoryChip(
                    chip = chips[index],
                    isSelected = selectedChipIndex == index,
                    onChipClick = {
                        onChipClick(index)
                    }
                )
                if (index != chips.size - 1) {
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }
}

@Composable
fun CategoryChip(
    chip: Chip,
    isSelected: Boolean,
    onChipClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors =
                    if (isSelected)
                        listOf(OrangeD8, RedD8)
                    else
                        listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surface
                        ),
                    startY = 0f
                )
            )
            .clickable {
                onChipClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = chip.iconId),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(28.dp),
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            modifier = Modifier
                .padding(end = 10.dp),
            text = chip.chipName,
            fontFamily = ReemKufi,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ChipSectionPreview() {
    ChipSection(
        chips = listOf(
            com.example.nonameapp.Chip(
                "Snacks",
                R.drawable.chip_snacks
            ),
            com.example.nonameapp.Chip(
                "Salads",
                R.drawable.chip_salad
            ),
            com.example.nonameapp.Chip(
                "Soups",
                R.drawable.chip_soup
            ),
            com.example.nonameapp.Chip(
                "Roman pizza",
                R.drawable.chip_pizza
            ),
            com.example.nonameapp.Chip(
                "Josper",
                R.drawable.chip_pizza
            ),
            com.example.nonameapp.Chip(
                "Other",
                R.drawable.chip_pizza
            ),
            com.example.nonameapp.Chip(
                "Prime",
                R.drawable.chip_pizza
            ),
            com.example.nonameapp.Chip(
                "Burgers",
                R.drawable.chip_burger
            ),
            com.example.nonameapp.Chip(
                "Side dishes",
                R.drawable.chip_sd
            ),
            com.example.nonameapp.Chip(
                "Sauces",
                R.drawable.chip_sauce
            ),
            com.example.nonameapp.Chip(
                "Desserts",
                R.drawable.chip_dessert
            ),
            com.example.nonameapp.Chip(
                "Drinks",
                R.drawable.chip_drink
            ),
            com.example.nonameapp.Chip(
                "Alcohol",
                R.drawable.chip_alco
            )
        ),
        selectedChipIndex = 0
    ) {

    }
}