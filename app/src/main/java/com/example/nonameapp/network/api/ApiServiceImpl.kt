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

class ApiServiceImpl(private val client: HttpClient): ApiService {
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