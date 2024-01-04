package com.example.nonameapp

import android.util.Log
import com.example.nonameapp.data.SharedPreferenceHelper
import com.example.nonameapp.network.ApiService
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import javax.inject.Inject

class MainRepository @Inject constructor(preferenceHelper: SharedPreferenceHelper) {

    private val apiService by lazy {
        ApiService.create()
    }

    suspend fun loginIntoAccount(email: String, password: String): Int {
        val responseCode = apiService.login(LoginRequestSerialization(email, password))
        Log.i("loginIntoAccount()","isSuccessful: $responseCode")
        return responseCode
    }
}