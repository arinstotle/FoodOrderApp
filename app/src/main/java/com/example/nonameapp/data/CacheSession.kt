package com.example.nonameapp.data

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.data.model.DishUIModel

class CacheSession {
    var cachedRestaurants: List<RestaurantUIModel>? = null
    var currRestaurant: RestaurantUIModel? = null

    var cachedDishesList: List<DishUIModel>? = null
}