package com.example.nonameapp

import java.util.UUID

data class Restaurant (
    val id: UUID,
    val city: String,
    val street: String,
    val house: String
)