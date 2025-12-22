package com.robert.cryptro.core.navigation

import android.widget.Toast
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.robert.cryptro.core.presentation.utils.ObserveAsEvents
import com.robert.cryptro.core.presentation.utils.toString
import com.robert.cryptro.crypto.presentation.coin_details.CoinDetailsScreen
import com.robert.cryptro.crypto.presentation.coin_list.CoinListAction
import com.robert.cryptro.crypto.presentation.coin_list.CoinListEvent
import com.robert.cryptro.crypto.presentation.coin_list.CoinListScreen
import com.robert.cryptro.crypto.presentation.coin_list.CoinListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AdaptiveCoinListDetailPane(
    modifier: Modifier = Modifier,
    viewModel: CoinListViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    val scope = rememberCoroutineScope()

    ObserveAsEvents(events = viewModel.events) { event ->
        when (event) {
            is CoinListEvent.Error -> {
                Toast.makeText(
                    context,
                    event.error.toString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                CoinListScreen(
                    state = state,
                    onAction = { action ->
                        viewModel.onAction(action)

                        when (action) {
                            is CoinListAction.OnCoinClick -> {
                                scope.launch {
                                    navigator.navigateTo(
                                        pane = ListDetailPaneScaffoldRole.Detail
                                    )
                                }
                            }

                            else -> Unit
                        }
                    }
                )
            }
        },
        detailPane = {
            AnimatedPane {
                CoinDetailsScreen(state = state)
            }
        },
        modifier = modifier
    )
}
