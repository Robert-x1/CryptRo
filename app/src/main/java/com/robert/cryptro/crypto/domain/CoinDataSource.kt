package com.robert.cryptro.crypto.domain

import com.robert.cryptro.core.domain.utils.NetworkError
import com.robert.cryptro.core.domain.utils.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>

}