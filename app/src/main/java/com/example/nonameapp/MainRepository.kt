package com.example.nonameapp

import com.example.nonameapp.data.CacheSession
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.network.ApiService
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import com.example.nonameapp.network.serializable.TablesRequestChangeIsFreeSerialization
import com.example.nonameapp.ui.dishesmenu.DishUIModel
import com.example.nonameapp.ui.reservation.components.TableUIModel
import java.util.UUID
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val preferenceHelper: SharedPreferenceHelper,
    private val cacheSession: CacheSession
) {

    private val apiService by lazy {
        ApiService.create()
    }

    // Register/login
    suspend fun loginIntoAccount(email: String, password: String): Int {
        return apiService.login(LoginRequestSerialization(email, password))
    }

    // GetDishes
    suspend fun getAllDishes(): List<DishUIModel>? {
        return if(cacheSession.currDishesList != null){
            cacheSession.currDishesList
        } else{
            val listOfDishes = apiService.getAllDishes()
            cacheSession.currDishesList = listOfDishes
            listOfDishes
        }
    }

    // Tables
    suspend fun getTablesByRestaurantId(restaurantId: UUID): List<TableUIModel>? {
        return apiService.getAllTablesByRestaurantId(restaurantId)
    }

    suspend fun updateTableIsFree(tableData: TablesRequestChangeIsFreeSerialization): Boolean {
        return apiService.updateTableIsFreeById(tableData)
    }
}