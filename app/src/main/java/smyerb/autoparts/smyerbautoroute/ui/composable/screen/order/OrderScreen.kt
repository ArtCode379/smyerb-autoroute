package smyerb.autoparts.smyerbautoroute.ui.composable.screen.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import smyerb.autoparts.smyerbautoroute.R
import smyerb.autoparts.smyerbautoroute.data.entity.OrderEntity
import smyerb.autoparts.smyerbautoroute.ui.composable.shared.VZBXVContentWrapper
import smyerb.autoparts.smyerbautoroute.ui.composable.shared.VZBXVEmptyView
import smyerb.autoparts.smyerbautoroute.ui.state.DataUiState
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {

        VZBXVContentWrapper(
            dataState = ordersState,

            dataPopulated = {
                val data = (ordersState as DataUiState.Populated).data

            },

            dataEmpty = {
                VZBXVEmptyView(
                    primaryText = stringResource(R.string.vzbxv_orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}