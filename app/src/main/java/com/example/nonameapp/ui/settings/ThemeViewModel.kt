package com.example.nonameapp.ui.settings

import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    val repository = 0

    fun getDataFromSharedPreferences(key: String, defaultValue: Boolean): Boolean {
        return true
    }

    fun saveDataToSharedPreferences(key: String, value: Boolean){

    }
}
