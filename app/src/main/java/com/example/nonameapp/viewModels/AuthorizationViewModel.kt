package com.example.nonameapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nonameapp.domain.LoginByEmailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    val loginByEmail: LoginByEmailUseCase
) : ViewModel() {

//    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.STARTED)
//    val loginUiState: StateFlow<LoginUiState> = _loginUiState

    private val _responseCode = MutableStateFlow<Int>(-1)
    val responseCode: StateFlow<Int> = _responseCode

    fun loginIntoAccount(email: String, password: String) {
        viewModelScope.launch {
            _responseCode.value = -1
            val response = loginByEmail(email = email, password = password)
            _responseCode.value = response
        }
    }
}
