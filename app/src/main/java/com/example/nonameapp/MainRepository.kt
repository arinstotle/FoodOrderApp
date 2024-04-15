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

/**
 * MainRepository handles data operations for the application.
 * It provides methods for interacting with various data sources such as API services, preferences, and local caches.
 *
 * @property preferenceHelper An instance of SharedPreferenceHelper for managing preferences.
 * @property cacheSession An instance of CacheSession for caching data.
 * @property cartManager An instance of CartManager for managing the shopping cart.
 * @property apiService An instance of ApiService for making API requests.
 */
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

    /**
     * Logs in the user into their account using the provided email and password.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return An integer representing the login status.
     */
    suspend fun loginIntoAccount(email: String, password: String): Int {
        return apiService.login(LoginRequestSerialization(email, password))
    }

    /**
     * Retrieves all dishes from the API or cache if available.
     *
     * @return A list of DishUIModel objects representing the dishes.
     */
    suspend fun getAllDishes(): List<DishUIModel>? {
        return if (cacheSession.cachedDishesList != null) {
            cacheSession.cachedDishesList
        } else {
            val listOfDishes = apiService.getAllDishes()
            cacheSession.cachedDishesList = listOfDishes
            listOfDishes
        }
    }

    /**
     * Retrieves all dishes filtered by the specified category from the cache.
     *
     * @param category The category to filter dishes by.
     * @return A list of DishUIModel objects filtered by the category.
     */
    fun getAllDishesByCategory(category: String): List<DishUIModel>? {
        return cacheSession.cachedDishesList?.filter { it.category == category }
    }

    /**
     * Retrieves tables for a specific restaurant from the API.
     *
     * @param restaurantId The UUID of the restaurant.
     * @return A list of TableUIModel objects representing tables.
     */
    suspend fun getTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>? {
        return apiService.getAllTablesByRestaurantId(restaurantId)
    }

    /**
     * Updates the availability status of a table.
     *
     * @param tableData The table data containing the ID and availability status.
     * @return A boolean indicating the success of the operation.
     */
    suspend fun updateTableIsFree(tableData: TablesRequestChangeIsFreeSerialization): Boolean {
        return apiService.updateTableIsFreeById(tableData)
    }

    /**
     * Retrieves all restaurants from the API or cache if available.
     *
     * @return A list of RestaurantUIModel objects representing restaurants.
     */
    suspend fun getAllRestaurants(): List<RestaurantUIModel>? {
        return if (cacheSession.cachedRestaurants != null) {
            cacheSession.cachedRestaurants
        } else {
            val listOfRestaurants = apiService.getAllRestaurants()
            cacheSession.cachedRestaurants = listOfRestaurants
            listOfRestaurants
        }
    }

    /**
     * Retrieves the currently selected restaurant.
     *
     * @return The current RestaurantUIModel object.
     */
    fun getCurrentRestaurant(): RestaurantUIModel? {
        return cacheSession.currRestaurant
    }

    /**
     * Sets the currently selected restaurant.
     *
     * @param restaurant The RestaurantUIModel object to set as the current restaurant.
     */
    fun setCurrentRestaurant(restaurant: RestaurantUIModel) {
        cacheSession.currRestaurant = restaurant
    }

    /**
     * Retrieves the currently selected dish for display in the dish information view.
     *
     * @return The current DishUIModel object.
     */
    fun getCurrentDishInDishInfo(): DishUIModel? {
        return cacheSession.currDish
    }

    /**
     * Sets the currently selected dish for display in the dish information view.
     *
     * @param dishUIModel The DishUIModel object to set as the current dish.
     */
    fun setCurrentDishInDishInfo(dishUIModel: DishUIModel) {
        cacheSession.currDish = dishUIModel
    }

    /**
     * Retrieves the state flow of dishes in the shopping cart.
     *
     * @return A StateFlow object containing a list of CartDishUIModel objects.
     */
    fun getDishesInCartStateFlow(): StateFlow<List<CartDishUIModel>> {
        return cartManager.dishesInCart
    }

    /**
     * Retrieves the state flow of the total sum of the shopping cart.
     *
     * @return A StateFlow object containing the total sum of the cart.
     */
    fun getSumCartStateFlow(): StateFlow<Int> {
        return cartManager.sumCart
    }

    /**
     * Adds a dish to the shopping cart.
     *
     * @param dishUIModel The DishUIModel object to add to the cart.
     */
    fun addToCart(dishUIModel: DishUIModel) {
        cartManager.addToCart(dishUIModel)
    }

    /**
     * Increases the quantity of a dish in the shopping cart.
     *
     * @param cartDishUIModel The CartDishUIModel object representing the dish in the cart.
     */
    fun increaseDishQuantity(cartDishUIModel: CartDishUIModel) {
        cartManager.increaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }

    /**
     * Decreases the quantity of a dish in the shopping cart.
     *
     * @param cartDishUIModel The CartDishUIModel object representing the dish in the cart.
     */
    fun decreaseDishQuantity(cartDishUIModel: CartDishUIModel) {
        cartManager.decreaseDishQuantity(cartDishUIModel = cartDishUIModel)
    }
}
