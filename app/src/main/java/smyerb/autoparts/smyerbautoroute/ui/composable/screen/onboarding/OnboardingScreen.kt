package smyerb.autoparts.smyerbautoroute.ui.composable.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import smyerb.autoparts.smyerbautoroute.R
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.VZBXVOnboardingVM

private data class OnboardingPage(val title: String, val description: String, val icon: ImageVector, val image: Int)

private val pages = listOf(
    OnboardingPage("Parts that fit your journey", "Browse dependable components and accessories grouped so the right choice is always close.", Icons.Default.Build, R.drawable.onboarding_1),
    OnboardingPage("Reserve in a few taps", "Build your basket, review the total and place a reservation with your contact details.", Icons.Default.ShoppingCart, R.drawable.onboarding_2),
    OnboardingPage("Ready within 24 hours", "Your confirmation includes an order number and collection details for a smooth store visit.", Icons.Default.CheckCircle, R.drawable.onboarding_3),
)

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: VZBXVOnboardingVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit,
) {
    val saved by viewModel.onboardingSetState.collectAsState()
    val pagerState = rememberPagerState(pageCount = { pages.size })
    LaunchedEffect(saved) {
        if (saved) onNavigateToHomeScreen()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
        ) { index ->
            val page = pages[index]
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Icon(page.icon, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(64.dp))
                Text(page.title, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
                Text(page.description, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
                Image(
                    painter = painterResource(page.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(18.dp)),
                )
            }
        }
        Row(horizontalArrangement = Arrangement.Center) {
            repeat(pages.size) { index ->
                Box(
                    Modifier
                        .padding(4.dp)
                        .size(if (pagerState.currentPage == index) 10.dp else 7.dp)
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == index) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.outline
                            }
                        )
                )
            }
        }
        if (pagerState.currentPage == pages.lastIndex) {
            Button(
                onClick = viewModel::setOnboarded,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
            ) {
                Text("Get Started")
            }
        } else {
            Text(
                text = "Swipe to continue",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 24.dp),
            )
        }
    }
}
