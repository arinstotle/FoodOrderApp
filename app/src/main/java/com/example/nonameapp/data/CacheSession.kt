package com.example.nonameapp.data

import com.example.nonameapp.Restaurant
import com.example.nonameapp.ui.dishesmenu.DishUIModel

class CacheSession {
    var currRestaurant: Restaurant? = null
    var currDishesList: List<DishUIModel>? = null
}