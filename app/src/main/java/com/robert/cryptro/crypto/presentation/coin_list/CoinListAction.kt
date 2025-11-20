package com.robert.cryptro.crypto.presentation.coin_list

import com.robert.cryptro.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick( val coinUI: CoinUI): CoinListAction
    data object OnRefresh : CoinListAction
}