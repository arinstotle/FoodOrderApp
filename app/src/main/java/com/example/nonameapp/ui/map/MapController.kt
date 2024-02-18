package com.example.nonameapp.ui.map

import android.content.Context
import android.util.Log
import com.example.nonameapp.R
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.CameraUpdateReason
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.map.PlacemarkMapObject
import com.yandex.mapkit.map.TextStyle
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MapController(private val context: Context) : CameraListener {
    private lateinit var mapObjectCollection: MapObjectCollection
    private lateinit var placemarkMapObject: PlacemarkMapObject
    private lateinit var mapView: MapView


    fun onCreate() {
        mapView.mapWindow.map.addCameraListener(this)
    }

    override fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean
    ) {
//        if (finished) {
//            val imageProvider = ImageProvider.fromResource(context, R.drawable.bull)
//            when {
//                cameraPosition.zoom >= MapConstants.ZOOM_BOUNDARY -> {
//                    placemarkMapObject.setIcon(imageProvider, IconStyle().setScale(0.1f))
//                }
//                cameraPosition.zoom <= MapConstants.ZOOM_BOUNDARY -> {
//                    placemarkMapObject.setIcon(imageProvider, IconStyle().setScale(0.1f))
//                }
//            }
//            MapConstants.zoomValue = cameraPosition.zoom
//            Log.i("MAPKIT", "Zoom = ${cameraPosition.zoom}, latitude = ${cameraPosition.target.latitude}, longitude = ${cameraPosition.target.longitude})")
//        }
    }


    fun addRestaurantMarker(restaurantPoint: Point, onClickListener: MapObjectTapListener) {
        mapObjectCollection = mapView.mapWindow.map.mapObjects
        placemarkMapObject = mapObjectCollection.addPlacemark().apply {
            geometry = restaurantPoint
            setIcon(ImageProvider.fromResource(context, R.drawable.bull), IconStyle().setScale(0.1f))
        }
        placemarkMapObject.setText("The Bull's Pit", TextStyle().setPlacement(TextStyle.Placement.BOTTOM))
        placemarkMapObject.addTapListener(onClickListener)
    }

    fun moveToRestaurant(restaurantPoint: Point) {
        mapView.mapWindow.map.move(
            CameraPosition(restaurantPoint, 16f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1f),
            null
        )
    }

    fun moveToStartPosition() {
        mapView.mapWindow.map.move(
            CameraPosition(MapConstants.startPosition, MapConstants.startZoom, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 1f),
            null
        )
    }

    fun setMapView(mapView: MapView){
        this.mapView = mapView
    }

    fun isMapViewInitialized() = ::mapView.isInitialized
}