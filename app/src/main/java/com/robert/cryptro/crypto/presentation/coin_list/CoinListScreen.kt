package com.robert.cryptro.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.robert.cryptro.crypto.presentation.coin_list.components.CoinListItem
import com.robert.cryptro.crypto.presentation.coin_list.components.previewCoin
import com.robert.cryptro.ui.theme.CryptRoTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {


    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    } else {


        Column(modifier = modifier.fillMaxSize()) {

            Spacer(Modifier.height(20.dp))

            LazyColumn(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(state.coins) { coinUI ->
                    CoinListItem(
                        modifier = Modifier.fillMaxHeight(),
                        coinUi = coinUI,
                        onClick = {
                            onAction(CoinListAction.OnCoinClick(coinUI))
                        }
                    )
                    HorizontalDivider()
                }
            }
        }

    }

}

@PreviewLightDark
@Composable
private fun coinListScreenPreview() {
    CryptRoTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    previewCoin.copy(id = it.toString())
                }
            ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            onAction = {}

        )
    }

}