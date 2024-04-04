package com.example.nonameapp

import com.example.nonameapp.data.model.CartDishUIModel
import com.example.nonameapp.data.source.CacheSession
import com.example.nonameapp.data.source.SharedPreferenceHelper
import com.example.nonameapp.network.api.ApiService
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.data.source.CartManager
import com.example.nonameapp.ui.reservation.components.TableUIModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val preferenceHelper: SharedPreferenceHelper,
    private val cacheSession: CacheSession,
    private val cartManager: CartManager,
    private val apiService: ApiService
) {
    private val mCoroutineScope = CoroutineScope(Dispatchers.IO)
    init {
        mCoroutineScope.launch {
            getAllRestaurants()
        }
    }

    // Register/login
    suspend fun loginIntoAccount(email: String, password: String): Int {
        return apiService.login(LoginRequestSerialization(email, password))
    }

    // Dishes
    suspend fun getAllDishes(): List<DishUIModel>? {
        return if (cacheSession.cachedDishesList != null) {
            cacheSession.cachedDishesList
        } else {
            val listOfDishes = apiService.getAllDishes()
            cacheSession.cachedDishesList = listOfDishes
            listOfDishes
        }
    }

    fun getAllDishesByCategory(category: String): List<DishUIModel>? {
        return cacheSession.cachedDishesList?.filter { it.category == category }
    }

    // Tables
    suspend fun getTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>? {
        return apiService.getAllTablesByRestaurantId(restaurantId)
    }

    suspend fun updateTableIsFree(tableData: TablesRequestChangeIsFreeSerialization): Boolean {
        return apiService.updateTableIsFreeById(tableData)
    }

    // Restaurants
    suspend fun getAllRestaurants(): List<RestaurantUIModel>? {
        return if (cacheSession.cachedRestaurants != null) {
            cacheSession.cachedRestaurants
        } else {
            val listOfRestaurants = apiService.getAllRestaurants()
            cacheSession.cachedRestaurants = listOfRestaurants
            listOfRestaurants
        }
    }

    fun getCurrentRestaurant(): RestaurantUIModel? {
        return cacheSession.currRestaurant
    }

    fun setCurrentRestaurant(restaurant: RestaurantUIModel) {
        cacheSession.currRestaurant = restaurant
    }

    fun getCurrentDishInDishInfo(): DishUIModel? {
        return cacheSession.currDish
    }

    fun setCurrentDishInDishInfo(dishUIModel: DishUIModel) {
        cacheSession.currDish = dishUIModel
    }

    fun getDishesInCartStateFlow(): StateFlow<List<CartDishUIModel>> {
        return cartManager.dishesInCart
    }

    fun getSumCartStateFlow(): StateFlow<Int> {
        return cartManager.sumCart
    }

    fun addToCart(dishUIModel: DishUIModel){
        cartManager.addToCart(dishUIModel)
    }

    fun increaseDishQuantity(cartDishUIModel: CartDishUIModel){
        cartManager.increaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }
    fun decreaseDishQuantity(cartDishUIModel: CartDishUIModel){
        cartManager.decreaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }
}