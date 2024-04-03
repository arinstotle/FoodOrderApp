package com.example.nonameapp.network.api

import com.example.nonameapp.RestaurantUIModel
import com.example.nonameapp.data.model.DishUIModel
import com.example.nonameapp.data.source.FoodDishesDataSource
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import com.example.nonameapp.ui.reservation.components.TableUIModel
import java.util.UUID

class MockedApiService(): ApiService  {
    override suspend fun login(loginData: LoginRequestSerialization): Int {
        return 200
    }

    override suspend fun getAllDishes(): List<DishUIModel> {
        return FoodDishesDataSource.listOfDishUIModel
    }

    override suspend fun getAllDishesByCategory(category: String): List<DishUIModel> {
        return FoodDishesDataSource.listOfDishUIModelOfCategoryOther
    }

    override suspend fun updateTableIsFreeById(tableData: TablesRequestChangeIsFreeSerialization): Boolean {
        return true
    }

    override suspend fun getAllTablesByRestaurantId(restaurantId: UUID): List<TableUIModel> {
        return FoodDishesDataSource.listOfTableUIModel
    }

    override suspend fun getAllRestaurants(): List<RestaurantUIModel> {
        return listOf()
    }

}