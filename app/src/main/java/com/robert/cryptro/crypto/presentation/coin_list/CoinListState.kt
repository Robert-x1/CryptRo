package com.robert.cryptro.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.crypto.presentation.models.CoinUI

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null,
    val error: String? = null,

)