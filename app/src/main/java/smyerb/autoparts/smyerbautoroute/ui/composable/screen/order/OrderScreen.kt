package smyerb.autoparts.smyerbautoroute.ui.composable.screen.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import smyerb.autoparts.smyerbautoroute.data.entity.OrderEntity
import smyerb.autoparts.smyerbautoroute.ui.composable.shared.VZBXVContentWrapper
import smyerb.autoparts.smyerbautoroute.ui.state.DataUiState
import smyerb.autoparts.smyerbautoroute.ui.theme.Success
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.OrderViewModel

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val state by viewModel.ordersState.collectAsState()
    VZBXVContentWrapper(
        dataState = state,
        dataPopulated = {
            OrderList(
                orders = (state as DataUiState.Populated).data.sortedByDescending { it.timestamp },
                modifier = modifier,
            )
        },
        dataEmpty = {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text("No orders yet", style = MaterialTheme.typography.headlineMedium)
                Text("Your reserved parts and collection details will appear here.")
            }
        },
    )
}

@Composable
private fun OrderList(orders: List<OrderEntity>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(orders, key = { it.orderNumber }) { order ->
            Card(shape = RoundedCornerShape(14.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Order #${order.orderNumber}", fontWeight = FontWeight.Bold)
                        Surface(color = Success.copy(alpha = 0.14f), shape = RoundedCornerShape(50)) {
                            Text("Completed", color = Success, modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
                        }
                    }
                    Text(order.timestamp.toLocalDate().toString(), color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(order.description)
                    Text("£%.2f".format(order.price), color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                    Text("Reserved for collection within 24 hours", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
