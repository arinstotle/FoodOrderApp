package com.example.nonameapp.data.source

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.data.model.DishUIModel

class CacheSession {
    var cachedRestaurants: List<RestaurantUIModel>? = null
    var currRestaurant: RestaurantUIModel? = null
    var currDish: DishUIModel? = null

    var cachedDishesList: List<DishUIModel>? = null
    var cachedCartDishes: List<DishUIModel>? = null
}