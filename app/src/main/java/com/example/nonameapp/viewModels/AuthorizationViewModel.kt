package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nonameapp.MainRepository
import kotlinx.coroutines.launch

class AuthorizationViewModel : ViewModel() {

    suspend fun loginIntoAccount(email: String, password: String): Int {
//        return repository.loginIntoAccount(email, password)
        // слезно прошу прощения, если ты найдешь это в моем коммите - надо заинжектить реп через фабрику вью моделей
        return 1
    }
}
