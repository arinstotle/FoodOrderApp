package com.example.nonameapp.network.api

import TablesResponseSerialization
import android.util.Log
import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.network.serializable.DishResponseSerialization
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import com.example.nonameapp.network.serializable.RestaurantsResponseSerialization
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.ui.reservation.components.TableUIModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import java.util.UUID

/**
 * Implementation of the ApiService interface for making API requests using Ktor HTTP client.
 *
 * @property client The HttpClient instance used for making HTTP requests.
 */
class ApiServiceImpl(private val client: HttpClient) : ApiService {

    /**
     * Performs user login using the provided login data.
     *
     * @param loginData The login request data.
     * @return An integer representing the login status.
     */
    override suspend fun login(loginData: LoginRequestSerialization): Int {
        return try {
            Log.i("login()", "email: ${loginData.email}, password: ${loginData.password}")
            val response: HttpResponse = client.post {
                url(ApiRoutes.BASE_URL + ApiRoutes.LOGIN)
                setBody(loginData)
            }
            response.status.value
        } catch (ex: Exception) {
            0
        }
    }

    /**
     * Retrieves a list of all dishes from the API.
     *
     * @return A list of DishUIModel objects representing dishes.
     */
    override suspend fun getAllDishes(): List<DishUIModel>? {
        return try {
            val dishes: List<DishUIModel> = client.get {
                url(ApiRoutes.BASE_URL + ApiRoutes.GET_ALL_DISHES)
            }.body<List<DishResponseSerialization>>()
                .map { it.convertToDishUIModel() }
            dishes
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Retrieves a list of dishes filtered by category from the API.
     *
     * @param category The category to filter dishes by.
     * @return A list of DishUIModel objects filtered by the category.
     */
    override suspend fun getAllDishesByCategory(category: String): List<DishUIModel>? {
        return try {
            val dishes: List<DishUIModel> = client.get {
                url(ApiRoutes.BASE_URL + ApiRoutes.GET_ALL_DISHES + category)
            }.body<List<DishResponseSerialization>>()
                .map { it.convertToDishUIModel() }
            dishes
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Updates the availability status of a table by its ID.
     *
     * @param tableData The table data containing the ID and availability status.
     * @return A boolean indicating the success of the operation.
     */
    override suspend fun updateTableIsFreeById(tableData: TablesRequestChangeIsFreeSerialization): Boolean {
        return try {
            val result = client.post {
                url(ApiRoutes.BASE_URL + ApiRoutes.TABLE)
                setBody(tableData)
            }
            result.status == HttpStatusCode.OK
        } catch (ex: Exception) {
            false
        }
    }

    /**
     * Retrieves a list of all tables for a specific restaurant from the API.
     *
     * @param restaurantId The UUID of the restaurant.
     * @return A list of TableUIModel objects representing tables.
     */
    override suspend fun getAllTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>? {
        return try {
            val tables: List<TablesResponseSerialization> = client.get {
                url(ApiRoutes.BASE_URL + ApiRoutes.TABLES + "/$restaurantId")
            }.body()

            tables.map { it.convertToTableUIModel() }
        } catch (ex: Exception) {
            null
        }
    }

    /**
     * Retrieves a list of all restaurants from the API.
     *
     * @return A list of RestaurantUIModel objects representing restaurants.
     */
    override suspend fun getAllRestaurants(): List<RestaurantUIModel>? {
        return try {
            val restaurants: List<RestaurantsResponseSerialization> = client.get {
                url(ApiRoutes.BASE_URL + ApiRoutes.RESTAURANTS)
            }.body()

            restaurants.map { it.convertToRestaurantUIModel() }
        } catch (ex: Exception) {
            null
        }
    }
}
