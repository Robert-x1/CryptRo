package com.robert.cryptro.crypto.domain

import com.robert.cryptro.crypto.presentation.coin_list.components.previewCoin

data class Coin(
    val id : String,
    val rank : Int,
    val symbol : String,
    val name : String,
    val marketCapUsd : Double,
    val priceUsd : Double,
    val changePercent24Hr : Double

)

