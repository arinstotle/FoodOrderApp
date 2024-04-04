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

interface ApiService {

    suspend fun login(loginData: LoginRequestSerialization): Int

    // Dishes
    suspend fun getAllDishes(): List<DishUIModel>?
    suspend fun getAllDishesByCategory(category: String): List<DishUIModel>?

    // Tables
    suspend fun updateTableIsFreeById(tableData: TablesRequestChangeIsFreeSerialization): Boolean
    suspend fun getAllTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>?

    // Restaurant
    suspend fun getAllRestaurants(): List<RestaurantUIModel>?
}