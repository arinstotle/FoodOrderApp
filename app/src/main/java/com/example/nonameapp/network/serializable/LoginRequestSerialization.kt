package com.example.nonameapp.network.serializable

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestSerialization(
    val email: String,
    val password: String
)

