package com.robert.cryptro.core.data.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.robert.cryptro.BuildConfig
import com.robert.cryptro.crypto.data.networking.dto.CoinApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


 object RetrofitFactory {

    fun create(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("Authorization", "Bearer ${BuildConfig.API_KEY}")
                    .header("Content-Type", "application/json")
                    .build()
                chain.proceed(request)

            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()

    }
    fun createApiService(retrofit: Retrofit): CoinApiService {
        return retrofit.create(CoinApiService::class.java)
    }
}

