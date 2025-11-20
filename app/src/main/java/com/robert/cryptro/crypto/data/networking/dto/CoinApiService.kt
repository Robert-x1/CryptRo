package com.robert.cryptro.crypto.data.networking.dto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApiService {
    @GET("assets")
    suspend fun getCoins(): CoinResponseDto

    @GET("assets/{coinId}/history")
    suspend fun getCoinHistory(
        @Path("coinId") coinId: String,
        @Query("interval") interval: String,
        @Query("start") start: Long,
        @Query("end") end: Long
    ): CoinHistoryDto

}