package com.robert.cryptro.crypto.data.mappers

import com.robert.cryptro.crypto.data.networking.dto.CoinDto
import com.robert.cryptro.crypto.data.networking.dto.CoinPriceDto
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneOffset

fun CoinDto.toCoin(): Coin{
    return Coin(
        id =id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr


    )
}
fun CoinPriceDto.toCoinPrice() : CoinPrice{
    return CoinPrice(
        priceUSD = price,
        time = Instant
            .ofEpochMilli(time)
            .atZone(ZoneOffset.UTC)
    )
}