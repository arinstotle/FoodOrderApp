package com.example.nonameapp

import android.util.Log
import com.example.nonameapp.network.ApiService
import com.example.nonameapp.network.serializable.LoginRequestSerialization

class MainRepository {

    private val apiService by lazy {
        ApiService.create()
    }

    suspend fun loginIntoAccount(email: String, password: String): Int {
        val responseCode = apiService.login(LoginRequestSerialization(email, password))
        Log.i("loginIntoAccount()","isSuccessful: $responseCode")
        return responseCode
    }
}