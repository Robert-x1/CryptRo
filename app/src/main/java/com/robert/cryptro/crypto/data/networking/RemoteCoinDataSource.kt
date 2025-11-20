package com.robert.cryptro.crypto.data.networking

import com.robert.cryptro.core.data.networking.safeApiCall
import com.robert.cryptro.core.domain.utils.NetworkError
import com.robert.cryptro.core.domain.utils.Result
import com.robert.cryptro.core.domain.utils.map
import com.robert.cryptro.crypto.data.mappers.toCoin
import com.robert.cryptro.crypto.data.mappers.toCoinPrice
import com.robert.cryptro.crypto.data.networking.dto.CoinApiService
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.crypto.domain.CoinDataSource
import com.robert.cryptro.crypto.domain.CoinPrice
import java.time.ZoneOffset
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val apiService: CoinApiService
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeApiCall {
            apiService.getCoins()
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(

        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {

        val startMillis = start
            .withZoneSameInstant(ZoneOffset.UTC)
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneOffset.UTC)
            .toInstant()
            .toEpochMilli()
        return safeApiCall {
            apiService.getCoinHistory(
                coinId = coinId,
                interval = "h6",
                start = startMillis,
                end = endMillis
            )
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}