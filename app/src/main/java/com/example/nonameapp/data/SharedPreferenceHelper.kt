package com.example.nonameapp.data

import android.content.Context
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor(
    val context: Context
) {

    private val preferences = context.getSharedPreferences("FoodAppPref", Context.MODE_PRIVATE)
    fun getShouldShowOnboarding(): Boolean = preferences.getBoolean("shouldShowOnboarding", true)

    fun setShouldShowOnboarding(shouldShow: Boolean) {
        preferences.edit().putBoolean("shouldShowOnboarding", shouldShow).apply()
    }

    fun getCurrentAuthUser(): String? = preferences.getString("currentAuthUserId", null)

    fun setCurrentAuthUser(currentUserId: String) {
        preferences.edit().putString("currentAuthUserId", currentUserId).apply()
    }

}