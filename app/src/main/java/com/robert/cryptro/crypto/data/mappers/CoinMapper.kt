package com.robert.cryptro.crypto.data.mappers

import com.robert.cryptro.crypto.data.networking.dto.CoinDto
import com.robert.cryptro.crypto.data.networking.dto.CoinPriceDto
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

fun CoinDto.toCoin(): Coin{
    return Coin(
        id =id,
        name = name,
        rank = rank.toInt(),
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDouble(),
        priceUsd = priceUsd.toDouble(),
        changePercent24Hr = changePercent24Hr.toDouble()


    )
}
fun CoinPriceDto.toCoinPrice() : CoinPrice{
    return CoinPrice(
        priceUSD = price.toDouble(),
        time = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}