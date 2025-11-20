package com.robert.cryptro.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice (
    val priceUSD: Double,
    val time: ZonedDateTime
)