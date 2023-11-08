package com.example.nonameapp.ui.map

import android.content.Context
import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavController
import com.example.nonameapp.databinding.MapScreenBinding
import com.example.nonameapp.util.startLocation
import com.example.nonameapp.util.zoomValue
import com.yandex.mapkit.Animation
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import com.example.nonameapp.R
import com.example.nonameapp.util.ZOOM_BOUNDARY
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraUpdateReason
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener

class MapController(val context: Context) : CameraListener {
    private lateinit var mapObjectCollection: MapObjectCollection
    private lateinit var placemarkMapObject: PlacemarkMapObject
    private lateinit var mapView: MapView


    fun onCreate() {
        MapKitFactory.getInstance().onStart()
        mapView.mapWindow.map.addCameraListener(this)
    }

    override fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean
    ) {
        if (finished) {
            when {
                cameraPosition.zoom >= ZOOM_BOUNDARY -> {
                    placemarkMapObject.setIcon(ImageProvider.fromResource(context, R.drawable.mini_borsh))
                }
                cameraPosition.zoom <= ZOOM_BOUNDARY -> {
                    placemarkMapObject.setIcon(ImageProvider.fromResource(context, R.drawable.borsh))
                }
            }
            zoomValue = cameraPosition.zoom
        }
    }

    fun setMarkerInStartLocation() {
        val marker = R.drawable.borsh
        mapObjectCollection = mapView.mapWindow.map.mapObjects
        placemarkMapObject = mapObjectCollection.addPlacemark(startLocation, ImageProvider.fromResource(context, marker))
        placemarkMapObject.opacity = placemarkMapObject.opacity / 2
        placemarkMapObject.setText("Обязательно к посещению!")
        placemarkMapObject.addTapListener(mapObjectTapListener)
    }

    private val mapObjectTapListener = object : MapObjectTapListener {
        override fun onMapObjectTap(p0: MapObject, p1: com.yandex.mapkit.geometry.Point): Boolean {
            Toast.makeText(context, "РТУ МИРЭА", Toast.LENGTH_SHORT).show()
            moveToStartLocation()
            return true
        }
    }

    fun moveToStartLocation() {
        mapView.mapWindow.map.move(
            CameraPosition(startLocation, mapView.mapWindow.map.cameraPosition.zoom * 1.5f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 2f),
            null
        )
    }

    fun setMapView(mapView: MapView){
        this.mapView = mapView
    }
}

@Composable
fun MapScreen(navController : NavController, mapController: MapController) {
    AndroidViewBinding(
        MapScreenBinding::inflate,
        modifier = Modifier
            .fillMaxSize()
    ) {
        mapview.onStop()
        mapview.onStart()
        mapController.setMapView(mapview)

        mapController.onCreate()
        mapController.moveToStartLocation()
        mapController.setMarkerInStartLocation()

    }
}