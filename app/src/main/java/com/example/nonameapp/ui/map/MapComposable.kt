package com.example.nonameapp.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavController
import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.databinding.MapScreenBinding
import com.example.nonameapp.viewModels.MapViewModel
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.MapObjectTapListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private var listOnRestaurantClick: MutableList<MapObjectTapListener> = mutableListOf()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    mapController: MapController,
    viewModel: MapViewModel
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var currentRestaurant: RestaurantUIModel? by remember { mutableStateOf(null) }
    val listOfRestaurants by viewModel.listOfRestaurants.collectAsState(initial = null)

    AndroidViewBinding(
        MapScreenBinding::inflate,
        modifier = Modifier
            .fillMaxSize(),
        update = {
            if (!mapController.isMapViewInitialized()) {
                if (listOnRestaurantClick.isNotEmpty())
                    listOnRestaurantClick = mutableListOf()

                mapview.onStart()
                mapController.setMapView(mapview)

                mapController.onCreate()

                if(listOfRestaurants != null){
                    for(restaurant in listOfRestaurants!!) {
                        val onRestaurantClick = MapObjectTapListener { mapObject, point ->
                            currentRestaurant = restaurant
                            showBottomSheet = true
                            mapController.moveToRestaurant(
                                restaurantPoint = Point(
                                    restaurant.latitude.toDouble(),
                                    restaurant.longitude.toDouble()
                                )
                            )
                            true
                        }
                        listOnRestaurantClick.add(onRestaurantClick)
                        mapController.addRestaurantMarker(
                            restaurantPoint = Point(
                                restaurant.latitude.toDouble(),
                                restaurant.longitude.toDouble()
                            ),
                            onClickListener = onRestaurantClick
                        )
                    }
                }
                mapController.moveToStartPosition()
            }
        },
        onReset = {
            mapview.onStop()
        }
    )

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            scrimColor = Color.Transparent
        ) {
            // Sheet content
            Text(text = currentRestaurant?.street ?: "null")
            Button(onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        showBottomSheet = false
                    }
                }
            }) {
                Text("Hide bottom sheet")
            }
        }
    }
}

