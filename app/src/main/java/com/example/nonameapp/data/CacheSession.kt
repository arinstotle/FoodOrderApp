package com.example.nonameapp.data

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.ui.dishesmenu.DishUIModel

class CacheSession {
    var cachedRestaurants: List<RestaurantUIModel>? = null
    var currRestaurant: RestaurantUIModel? = null

    var cachedDishesList: List<DishUIModel>? = null
}