package com.robert.cryptro.crypto.presentation.coin_details

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robert.cryptro.R
import com.robert.cryptro.crypto.presentation.coin_details.components.InfoCard
import com.robert.cryptro.crypto.presentation.coin_list.CoinListState
import com.robert.cryptro.crypto.presentation.coin_list.components.previewCoin
import com.robert.cryptro.crypto.presentation.models.toDisplayableNumber
import com.robert.cryptro.ui.theme.CryptRoTheme
import com.robert.cryptro.ui.theme.primaryContainerLightHighContrast

@Composable
fun CoinDetailsScreen(
    state: CoinListState,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    } else if (state.selectedCoin != null) {
        val coin = state.selectedCoin
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = coin.iconResId),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = coin.name,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = coin.name,
                color = contentColor,
                fontWeight = FontWeight.Black,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = coin.symbol,
                color = contentColor,
                fontWeight = FontWeight.Light,
                fontSize = 40.sp,
                textAlign = TextAlign.Center
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                InfoCard(
                    title = stringResource(R.string.market_cap),
                    formattedText = "$ ${coin.marketCapUsd.formatted}",
                    icon = ImageVector.vectorResource(R.drawable.stock),
                )
                InfoCard(
                    title = stringResource(R.string.price),
                    formattedText = "$ ${coin.priceUsd.formatted}",
                    icon = ImageVector.vectorResource(R.drawable.dollar),
                )
                val absoluteChangeFormatted =
                    (coin.priceUsd.value * (coin.changePercent24Hr.value / 100))
                        .toDisplayableNumber()
                val isPositive = coin.changePercent24Hr.value > 0.0
                val contentColor = if (isPositive) {
                    if (isSystemInDarkTheme()) Color.Green else primaryContainerLightHighContrast
                } else {
                    MaterialTheme.colorScheme.error
                }

                InfoCard(
                    title = stringResource(R.string.Change_last_24h),
                    formattedText = absoluteChangeFormatted.formatted,
                    icon = if (isPositive){
                        ImageVector.vectorResource(R.drawable.trending)
                    }else{
                        ImageVector.vectorResource(R.drawable.trending_down)

                    },
                    contentColor = contentColor,
                )

            }


        }
    }

}
@PreviewLightDark
@Composable
private fun CoinDetailsScreenPreview() {
    CryptRoTheme {
        CoinDetailsScreen(
            state = CoinListState(
                selectedCoin = previewCoin,

                ),
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )

        )
    }


}