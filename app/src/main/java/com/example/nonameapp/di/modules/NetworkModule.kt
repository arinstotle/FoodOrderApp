package com.example.nonameapp.di.modules

import com.example.nonameapp.di.scopes.AppScope
import com.example.nonameapp.network.api.ApiService
import com.example.nonameapp.network.api.MockedApiService
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
//    @Provides
//    @AppScope
//    fun provideApiService(): ApiService {
//        return ApiServiceImpl(
//            client = HttpClient(Android) {
//
//                // Logging
//                install(Logging) {
//                    logger = object : Logger {
//                        override fun log(message: String) {
//                            Log.d("HTTP call", message)
//                        }
//                    }
//                    level = LogLevel.ALL
//                }
//
//                // JSON
//                install(ContentNegotiation) {
//                    register(ContentType.Text.Plain, KotlinxSerializationConverter(Json {
//                        prettyPrint = true
//                        isLenient = true
//                        ignoreUnknownKeys = true
//
//                    }))
//                    json(Json {
//                        prettyPrint = true
//                        isLenient = true
//                        encodeDefaults = false
//                        ignoreUnknownKeys = true
//                    })
//                }
//
//                // Timeout
//                install(HttpTimeout) {
//                    requestTimeoutMillis = 15000L
//                    connectTimeoutMillis = 15000L
//                    socketTimeoutMillis = 15000L
//                }
//
//                // Apply to all requests
//                defaultRequest {
//                    contentType(ContentType.Application.Json)
//                    accept(ContentType.Application.Json)
//                }
//            }
//        )
//    }

    @Provides
    @AppScope
    fun provideApiService(): ApiService {
        return MockedApiService()
    }
}