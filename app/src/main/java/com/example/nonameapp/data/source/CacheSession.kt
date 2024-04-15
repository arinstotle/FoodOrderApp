package com.example.nonameapp.data.source

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.data.model.DishUIModel

/**
 * CacheSession manages the cached data for the application.
 * It holds information such as cached restaurants, current restaurant selection, current dish selection,
 * cached list of dishes, and cached cart dishes.
 */
class CacheSession {
    /**
     * A list of cached restaurants.
     */
    var cachedRestaurants: List<RestaurantUIModel>? = null

    /**
     * The currently selected restaurant.
     */
    var currRestaurant: RestaurantUIModel? = null

    /**
     * The currently selected dish.
     */
    var currDish: DishUIModel? = null

    /**
     * A list of cached dishes.
     */
    var cachedDishesList: List<DishUIModel>? = null

    /**
     * A list of cached cart dishes.
     */
    var cachedCartDishes: List<DishUIModel>? = null
}
