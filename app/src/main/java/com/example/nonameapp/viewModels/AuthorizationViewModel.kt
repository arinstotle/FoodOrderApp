package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nonameapp.MainRepository
import kotlinx.coroutines.launch

class AuthorizationViewModel : ViewModel() {

    private val repository = MainRepository()

    suspend fun loginIntoAccount(email: String, password: String): Boolean{
        return repository.loginIntoAccount(email, password)
    }
}
