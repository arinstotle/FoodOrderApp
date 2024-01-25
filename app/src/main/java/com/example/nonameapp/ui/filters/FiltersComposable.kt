package com.example.nonameapp.ui.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nonameapp.Chip
import com.example.nonameapp.R
import com.example.nonameapp.data.FoodDishesDataSource
import com.example.nonameapp.ui.CustomTopAppBarComposable
import com.example.nonameapp.ui.filters.components.ApplyButton
import com.example.nonameapp.ui.filters.components.FilterComponent
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersComposable(
    navController: NavController
) {
    var chosenCategory by remember { mutableStateOf(Chip("All")) }
    var chosenCookingTime by remember { mutableStateOf(Chip("All")) }
    var chosenDiet by remember { mutableStateOf(Chip("All")) }
    var chosenKitchen by remember { mutableStateOf(Chip("All")) }
    var chosenSort by remember { mutableStateOf(Chip("All")) }

    Scaffold(
        topBar = {
            CustomTopAppBarComposable(
                titleText = stringResource(id = R.string.filters_top_bar_title),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                isHaveNavIcon = true,
                onNavIconClick = {
                    navController.popBackStack()
                },
                actions = {
                    IconButton(onClick = {
                        val chipAll = Chip("All")
                        chosenCategory = chipAll
                        chosenCookingTime = chipAll
                        chosenDiet = chipAll
                        chosenKitchen = chipAll
                        chosenSort = chipAll
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.clear_filter),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }
                }
            )
        }
    ) { topBarPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(topBarPadding)
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp)
                    .verticalScroll(state = rememberScrollState())
            ) {

                // Category
                FilterComponent(
                    title = stringResource(id = R.string.filters_category_title),
                    listOfChips = FoodDishesDataSource.listOfChips,
                    modifier = Modifier
                        .padding(top = 20.dp),
                    chosenChip = chosenCategory,
                    onChipClick = { chip ->
                        chosenCategory = chip
                    }
                )

                // Cooking time
                FilterComponent(
                    title = stringResource(id = R.string.filters_cooking_time_title),
                    listOfChips = FoodDishesDataSource.listOfCookingTime,
                    modifier = Modifier
                        .padding(top = 30.dp),
                    chosenChip = chosenCookingTime,
                    onChipClick = { chip ->
                        chosenCookingTime = chip
                    }
                )

                // Diet
                FilterComponent(
                    title = stringResource(id = R.string.filters_diet_title),
                    listOfChips = FoodDishesDataSource.listOfDiet,
                    modifier = Modifier
                        .padding(top = 30.dp),
                    chosenChip = chosenDiet,
                    onChipClick = { chip ->
                        chosenDiet = chip
                    }
                )

                // Kitchen
                FilterComponent(
                    title = stringResource(id = R.string.filters_kitchen_title),
                    listOfChips = FoodDishesDataSource.listOfKitchen,
                    modifier = Modifier
                        .padding(top = 30.dp),
                    chosenChip = chosenKitchen,
                    onChipClick = { chip ->
                        chosenKitchen = chip
                    }
                )

                // Sort by
                FilterComponent(
                    title = stringResource(id = R.string.filters_sort_by_title),
                    listOfChips = FoodDishesDataSource.listOfSort,
                    modifier = Modifier
                        .padding(top = 30.dp, bottom = 100.dp),
                    chosenChip = chosenSort,
                    onChipClick = { chip ->
                        chosenSort = chip
                    }
                )
            }

            //
            ApplyButton(
                text = stringResource(id = R.string.checkout_promo_code_apply),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .align(Alignment.BottomCenter),

            ){
                /* TODO: Apply filters */
                /* TODO: Navigate to SearchScreen */
                navController.popBackStack()
            }
        }
    }
}