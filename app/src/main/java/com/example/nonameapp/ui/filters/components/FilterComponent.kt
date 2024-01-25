package com.example.nonameapp.ui.filters.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.Chip
import com.example.nonameapp.R
import com.example.nonameapp.data.FoodDishesDataSource
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterComponent(
    title: String,
    listOfChips: List<Chip>,
    chosenChip: Chip,
    onChipClick: (chip: Chip) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        FlowRow(

        ) {
            FilterChip(
                title = "All",
                isSelected = chosenChip.chipName == "All",
                modifier = Modifier
                    .padding(top = 10.dp, end = 15.dp),
                onClick = {
                    onChipClick(Chip("All"))
                }
            )
            for (chip in listOfChips) {
                FilterChip(
                    title = chip.chipName,
                    isSelected = chip.chipName == chosenChip.chipName,
                    modifier = Modifier.padding(top = 10.dp, end = 15.dp),
                    onClick = {
                        onChipClick(chip)
                    }
                )
            }
        }
    }
}

@Composable
private fun FilterChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected)
        Brush.horizontalGradient(listOf(OrangeD8, RedD8))
    else
        Brush.horizontalGradient(
            listOf(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.surface
            )
        )

    Box(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(25.dp)
            )
            .clip(RoundedCornerShape(25.dp))
            .background(
                brush = backgroundColor,
                shape = RoundedCornerShape(25.dp)
            )
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontFamily = ReemKufi,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FilterComponentPreview() {
    AppTheme {
        Column {
            FilterComponent(
                title = stringResource(id = R.string.filters_category_title),
                listOfChips = FoodDishesDataSource.listOfChips,
                chosenChip = Chip("Snacks"),
                onChipClick = {  }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FilterChipPreview() {
    AppTheme {
        FlowRow {
            FilterChip(
                title = "All",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {})
            FilterChip(
                title = "Snacks",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
            FilterChip(
                title = "Salads",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
            FilterChip(
                title = "Soups",
                isSelected = true,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {})
            FilterChip(
                title = "Roman pizza",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
            FilterChip(
                title = "Josper",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
            FilterChip(
                title = "Other",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
            FilterChip(
                title = "Prime",
                isSelected = false,
                modifier = Modifier.padding(end = 15.dp),
                onClick = {}
            )
        }
    }
}