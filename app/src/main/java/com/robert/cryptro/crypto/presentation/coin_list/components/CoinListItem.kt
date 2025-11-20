package com.robert.cryptro.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robert.cryptro.crypto.domain.Coin
import com.robert.cryptro.crypto.presentation.models.CoinUI
import com.robert.cryptro.crypto.presentation.models.toCoinUI
import com.robert.cryptro.ui.theme.CryptRoTheme

@Composable
fun CoinListItem(
    coinUi: CoinUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconResId),
            contentDescription = coinUi.id,
            tint = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .padding(5.dp)
                .size(85.dp),

            )
        Column(
            Modifier.weight(1f)
        ) {
            Text(
                coinUi.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(
                coinUi.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
        }
        Column (horizontalAlignment = Alignment.End){
            Text(
                "$ ${coinUi.priceUsd.formatted}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            PriceChange(coinUi.changePercent24Hr)
        }
    }

}


@PreviewLightDark
@PreviewDynamicColors
@Composable
private fun CoinItemTestPreview() {
    CryptRoTheme {
        CoinListItem(
            coinUi = previewCoin,
            onClick = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }

}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    symbol = "BTC",
    name = "Bitcoin",
    marketCapUsd = 1241273958896.75,
    priceUsd = 120153.15,
    changePercent24Hr = 2.502
).toCoinUI()