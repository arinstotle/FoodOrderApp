package com.example.nonameapp.ui.dishCardInfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.network.api.ApiRoutes
import com.example.nonameapp.viewModels.DishCardInfoViewModel
import java.util.UUID

@Composable
fun DishCardInfoComposable(
    navController: NavController,
    viewModel: DishCardInfoViewModel
){
//    val dishUIModel: DishUIModel = DishUIModel(
//        id = UUID.randomUUID(),
//        category = "Other",
//        name = "Pork Set",
//        imageSource = "/dishes/dish_pork_set.jpg",
//        price = 500,
//        grams = 343,
//        timeToCook = 45,
//        rating = 4.2f,
//        orderedTimes = 10,
//        description = "pork pork",
//        ingredients = listOf()
//    )

    val dishUIModel = viewModel.performGetCurrentDish()

    Scaffold(

    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .padding(scaffoldPadding)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            ){
                SubcomposeAsyncImage(
                    model = ApiRoutes.BASE_URL + ApiRoutes.FILES_DIRECTORY + dishUIModel?.imageSource,
                    contentDescription = "Image of dish",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            IconButton(
                onClick = {
                    viewModel.performAddToCart()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add to cart"
                )
            }
        }
    }
}