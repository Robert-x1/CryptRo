package com.robert.cryptro

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.robert.cryptro.core.navigation.AdaptiveCoinListDetailPane
import com.robert.cryptro.core.presentation.utils.ObserveAsEvents
import com.robert.cryptro.core.presentation.utils.toString
import com.robert.cryptro.crypto.presentation.coin_details.CoinDetailsScreen
import com.robert.cryptro.crypto.presentation.coin_list.CoinListEvent
import com.robert.cryptro.crypto.presentation.coin_list.CoinListScreen
import com.robert.cryptro.crypto.presentation.coin_list.CoinListViewModel
import com.robert.cryptro.ui.theme.CryptRoTheme
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptRoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )

                }


            }
        }
    }
}

