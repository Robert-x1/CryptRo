package com.robert.cryptro.crypto.presentation.coin_list

import com.robert.cryptro.core.domain.utils.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}