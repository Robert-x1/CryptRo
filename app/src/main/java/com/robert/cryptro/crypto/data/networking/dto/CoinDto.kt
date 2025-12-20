package com.robert.cryptro.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    val id: String,
    val rank: String,
    val name: String,
    val symbol: String,
    val marketCapUsd: String,
    val priceUsd: String,
    val changePercent24Hr: String

)
