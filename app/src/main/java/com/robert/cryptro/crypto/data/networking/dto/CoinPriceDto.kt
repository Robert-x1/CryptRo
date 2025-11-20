package com.robert.cryptro.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDto(

    val price: Double,
    val time: Long

)
