package com.example.nonameapp.network.serializable

import com.example.nonameapp.network.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class TablesRequestChangeIsFreeSerialization(
    val id: @Serializable(with = UUIDSerializer::class) UUID,
    val is_free: Boolean
)
