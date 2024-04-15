package com.example.nonameapp.network.api

import android.util.Log
import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.ui.reservation.components.TableUIModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.UUID

/**
 * ApiService is an interface for interacting with the remote API.
 */
interface ApiService {
    /**
     * Logs in the user using the provided login data.
     *
     * @param loginData The login request data.
     * @return An integer representing the login status.
     */
    suspend fun login(loginData: LoginRequestSerialization): Int

    // Dishes

    /**
     * Retrieves all dishes from the API.
     *
     * @return A list of DishUIModel objects representing dishes.
     */
    suspend fun getAllDishes(): List<DishUIModel>?

    /**
     * Retrieves all dishes filtered by category from the API.
     *
     * @param category The category to filter dishes by.
     * @return A list of DishUIModel objects filtered by the category.
     */
    suspend fun getAllDishesByCategory(category: String): List<DishUIModel>?

    // Tables

    /**
     * Updates the availability status of a table by its ID.
     *
     * @param tableData The table data containing the ID and availability status.
     * @return A boolean indicating the success of the operation.
     */
    suspend fun updateTableIsFreeById(tableData: TablesRequestChangeIsFreeSerialization): Boolean

    /**
     * Retrieves all tables for a specific restaurant from the API.
     *
     * @param restaurantId The UUID of the restaurant.
     * @return A list of TableUIModel objects representing tables.
     */
    suspend fun getAllTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>?

    // Restaurant

    /**
     * Retrieves all restaurants from the API.
     *
     * @return A list of RestaurantUIModel objects representing restaurants.
     */
    suspend fun getAllRestaurants(): List<RestaurantUIModel>?
}
