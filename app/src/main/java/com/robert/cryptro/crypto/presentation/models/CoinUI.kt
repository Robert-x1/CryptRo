package com.robert.cryptro.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.core.presentation.utils.getDrawableIdForCoin
import java.util.Locale

//12131653032013.25
data class CoinUI(
    val id : String,
    val rank : Int,
    val symbol : String,
    val name : String,
    val marketCapUsd : DisplayableNumber,
    val priceUsd : DisplayableNumber,
    val changePercent24Hr : DisplayableNumber,
    @DrawableRes val iconResId: Int
)

data class DisplayableNumber(
  val value: Double,
  val formatted: String

)


fun Coin.toCoinUI(): CoinUI {
    return CoinUI(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconResId = getDrawableIdForCoin(symbol)
    )
}

object Formatter {
    private val numberFormat: NumberFormat by lazy {
        NumberFormat.getNumberInstance(Locale.getDefault()).apply {
            maximumFractionDigits = 1
            minimumFractionDigits = 1
        }
    }

    fun format(value: Double): String = numberFormat.format(value)
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    return DisplayableNumber(
        value = this,
        formatted = Formatter.format(this)
    )
}
