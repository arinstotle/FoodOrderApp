package com.example.nonameapp.domain

import com.example.nonameapp.MainRepository

/**
 * LoginByEmailUseCase performs user login using email and password.
 *
 * @property repository The MainRepository instance to perform the login operation.
 */
class LoginByEmailUseCase(
    private val repository: MainRepository
) {
    /**
     * Invokes the use case to perform user login using email and password.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return An integer representing the login status.
     */
    suspend operator fun invoke(email: String, password: String): Int {
       return repository.loginIntoAccount(email, password)
    }
}
