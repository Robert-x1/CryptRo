package com.robert.cryptro.crypto.data.networking.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDto(

    @SerialName("priceUsd")
    val price: String,
    val time: Long

)
