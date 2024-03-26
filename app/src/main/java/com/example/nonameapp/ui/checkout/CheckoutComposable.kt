package com.example.nonameapp.ui.checkout

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.R
import com.example.nonameapp.data.source.FoodDishesDataSource
import com.example.nonameapp.data.source.PaymentCardsDataSource
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.CustomTopAppBarComposable
import com.example.nonameapp.ui.checkout.components.BonusComponent
import com.example.nonameapp.ui.checkout.components.CartComponent
import com.example.nonameapp.ui.checkout.components.PaymentMethodComponent
import com.example.nonameapp.ui.checkout.components.PromoCodeComponent
import com.example.nonameapp.ui.checkout.components.RestaurantComponent
import com.example.nonameapp.ui.checkout.components.SlideToPay
import com.example.nonameapp.ui.checkout.components.SubtotalComponent
import com.example.nonameapp.ui.checkout.components.TableComponent
import com.example.nonameapp.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(
    navController: NavController
) {
    var chosenCardIndex by remember { mutableIntStateOf(-1) }
    var bonusCount by remember { mutableIntStateOf(150) }
    var bonusChecked by remember { mutableStateOf(false) }
    var slideThumbLoading by remember { mutableStateOf(false) }

    var subtotalRub by remember { mutableIntStateOf(1000) }
    var discountRub by remember { mutableIntStateOf(0) }
    var discountPromoCodeRub by remember { mutableIntStateOf(0) }
    var totalRub by remember { mutableIntStateOf(subtotalRub - discountRub - discountPromoCodeRub) }

    Scaffold(
        topBar = {
            CustomTopAppBarComposable(
                titleText = stringResource(id = R.string.checkout_top_bar_title),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                isHaveNavIcon = true,
                onNavIconClick = {
                    navController.popBackStack()
                }
            )
        }
    ) { topPadding ->
        Column(
            modifier = Modifier
                .padding(topPadding)
                .padding(start = 20.dp)
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
        ) {

            CartComponent(
                dishesList = FoodDishesDataSource.listOfCartDishes,
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            RestaurantComponent(
                onEditClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            TableComponent(
                onEditClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            PaymentMethodComponent(
                paymentCards = PaymentCardsDataSource.listPaymentCards,
                chosenCardIndex = chosenCardIndex,
                onChangedChosenCard = { newCardIndex ->
                    chosenCardIndex = newCardIndex
                },
                onClickAddNewCard = {
                    navController.navigate(Screen.NewCardScreen.route)
                },
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            BonusComponent(
                bonusCount = bonusCount,
                isChecked = bonusChecked,
                onClick = {
                    bonusChecked = !bonusChecked
                    discountRub = if(bonusChecked) bonusCount else 0
                    totalRub = subtotalRub - discountRub
                },
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            PromoCodeComponent(
                onApply = { promoCode ->
                    /* TODO: Apply Promo code */
                    val isSuccess = promoCode == "TODO"
                    discountPromoCodeRub = if(isSuccess) 100 else 0

                    totalRub = subtotalRub - discountRub - discountPromoCodeRub
                    isSuccess
                },
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp)
            )

            Divider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 40.dp, end = 20.dp)
            )

            SubtotalComponent(
                subtotalRub = subtotalRub,
                discountRub = discountRub,
                discountPromoCodeRub = discountPromoCodeRub,
                totalRub = totalRub,
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp)
            )

            SlideToPay(
                isCardChosen = chosenCardIndex != -1,
                isLoading = slideThumbLoading,
                onUnlockRequested = {
                    slideThumbLoading = true
                    // TODO: Send payment request to backend
                },
                modifier = Modifier
                    .padding(top = 20.dp, end = 20.dp, bottom = 20.dp)
            )
        }
    }
}

@Preview(name = "MI9T (NIGHT)", device = "spec:width=1080px,height=2340px", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CheckoutPreviewNight() {
    AppTheme {
        CheckoutScreen(rememberNavController())
    }
}

@Preview(name = "MI9T (DAY)", device = "spec:width=1080px,height=2340px", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun CheckoutPreviewDay() {
    AppTheme {
        CheckoutScreen(rememberNavController())
    }
}
