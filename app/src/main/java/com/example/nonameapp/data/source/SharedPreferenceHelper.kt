package com.example.nonameapp.data.source

import android.content.Context
import javax.inject.Inject

/**
 * This class provides helper methods to manage shared preferences related to the FoodApp.
 * These preferences include settings like whether onboarding screens should be displayed
 * or the currently authenticated user ID.
 *
 * @property context The application context used to access shared preferences.
 * @constructor Creates an instance of SharedPreferenceHelper with the provided context.
 */
class SharedPreferenceHelper @Inject constructor(
    val context: Context
) {
    private val foodAppPref = "FoodAppPref"
    private val shouldShowOnboarding = "shouldShowOnboarding"
    private val currentAuthUserId = "currentAuthUserId"

    private val preferences = context.getSharedPreferences(foodAppPref, Context.MODE_PRIVATE)

    /**
     * Retrieves the current status of the onboarding screens display preference.
     *
     * @return True if onboarding screens should be displayed, false otherwise.
     */
    fun getShouldShowOnboarding(): Boolean = preferences.getBoolean(shouldShowOnboarding, true)

    /**
     * Sets the status of the onboarding screens display preference.
     *
     * @param shouldShow Boolean indicating whether onboarding screens should be displayed.
     */
    fun setShouldShowOnboarding(shouldShow: Boolean) {
        preferences.edit().putBoolean(shouldShowOnboarding, shouldShow).apply()
    }

    /**
     * Retrieves the ID of the currently authenticated user.
     *
     * @return The ID of the currently authenticated user, or null if no user is authenticated.
     */
    fun getCurrentAuthUser(): String? = preferences.getString(currentAuthUserId, null)

    /**
     * Sets the ID of the currently authenticated user.
     *
     * @param currentUserId The ID of the currently authenticated user to be saved.
     */
    fun setCurrentAuthUser(currentUserId: String) {
        preferences.edit().putString(currentAuthUserId, currentUserId).apply()
    }
}