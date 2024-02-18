package com.example.nonameapp.ui.map

import com.example.nonameapp.RestaurantUIModel
import com.yandex.mapkit.geometry.Point
import java.util.UUID

object MapConstants {
    val startPosition = Point(55.756983, 37.612233)
    val startZoom = 10f
    val listOfRestaurantsPoints: List<RestaurantUIModel> = listOf(
        RestaurantUIModel(
            id = UUID.fromString("109bda53-7752-49be-9cf2-097a44b176e6"),
            city = "Moscow",
            street = "Vernadsky Prospekt",
            house = "78b4",
            latitude = 55.67009f,
            longitude = 37.480907f
        ),
        RestaurantUIModel(
            id = UUID.fromString("109bda53-7752-49be-9cf2-097a44b176e7"),
            city = "Moscow",
            street = "11-ya Parkovaya",
            house = "36",
            latitude = 55.801018f,
            longitude = 37.80573f
        ),
//        Point(55.746851, 37.654852),    // amoCRM
    )
    var zoomValue: Float = 17.35f
    const val ZOOM_BOUNDARY = 16.4f
}