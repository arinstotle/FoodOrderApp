package com.example.nonameapp.network

import android.util.Log
import com.example.nonameapp.network.serializable.LoginRequestSerialization
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface ApiService {

    suspend fun login(loginData: LoginRequestSerialization): Int

    companion object {
        fun create(): ApiServiceImpl {
            return ApiServiceImpl(
                client = HttpClient(Android) {

                    // Logging
                    install(Logging) {
                        logger = object : Logger {
                            override fun log(message: String) {
                                Log.d("HTTP call", message)
                            }
                        }
                        level = LogLevel.ALL
                    }

                    // JSON
                    install(ContentNegotiation) {
                        register(ContentType.Text.Plain, KotlinxSerializationConverter(Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true

                        }))
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                            encodeDefaults = false
                            ignoreUnknownKeys = true
                        })
                    }

                    // Timeout
                    install(HttpTimeout) {
                        requestTimeoutMillis = 15000L
                        connectTimeoutMillis = 15000L
                        socketTimeoutMillis = 15000L
                    }

                    // Apply to all requests
                    defaultRequest {
                        contentType(ContentType.Application.Json)
                        accept(ContentType.Application.Json)
                    }
                }
            )
        }
    }
}