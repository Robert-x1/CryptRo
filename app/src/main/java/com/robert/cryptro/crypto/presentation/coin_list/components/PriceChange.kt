package com.robert.cryptro.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robert.cryptro.crypto.presentation.models.DisplayableNumber
import com.robert.cryptro.ui.theme.errorLight


@Composable
fun PriceChange(change: DisplayableNumber, modifier: Modifier = Modifier) {
    val greenBackground = Color(0xFF00FF1A)
    val greenBackground2 = Color(0xFF005E0E)
    val contentColor = if (change.value < 0.0) errorLight else Color.Green
    val backgroundColor =
        if (change.value < 0.0) {
            if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
            } else {
                MaterialTheme.colorScheme.errorContainer


            }
        } else {
            if (isSystemInDarkTheme()) {
                greenBackground.copy(alpha = 0.1f)
            } else {
                greenBackground2.copy(alpha = 0.4f)

            }
        }

    Row(
        Modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor)
            .padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (change.value < 0.0) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor,
        )
        Text(
            "${change.formatted}%",
            fontSize = 14.sp,
            color = contentColor,
            fontWeight = FontWeight.Medium
        )
    }

}

@PreviewLightDark
@Composable
private fun PriceChangePreview() {
    PriceChange(
        change = DisplayableNumber(
            value = -2.75, formatted = "2.52 %"
        )
    )


}