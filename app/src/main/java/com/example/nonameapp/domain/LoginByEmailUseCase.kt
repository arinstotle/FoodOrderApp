package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository

class LoginByEmailUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(email: String, password: String): Int {
       return repository.loginIntoAccount(email, password)
    }
}