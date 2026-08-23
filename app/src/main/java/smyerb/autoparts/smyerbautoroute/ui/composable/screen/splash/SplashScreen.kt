package smyerb.autoparts.smyerbautoroute.ui.composable.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel
import smyerb.autoparts.smyerbautoroute.R
import smyerb.autoparts.smyerbautoroute.ui.theme.GradientEnd
import smyerb.autoparts.smyerbautoroute.ui.theme.GradientStart
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.VZBXVSplashVM
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: VZBXVSplashVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToOnboarding: () -> Unit,
) {
    val onboarded by viewModel.onboardedState.collectAsStateWithLifecycle()
    val progress = androidx.compose.runtime.remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(1f, tween(800))
        delay(700)
        if (onboarded) onNavigateToHomeScreen() else onNavigateToOnboarding()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(GradientStart, GradientEnd))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.vzbxv_ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(140.dp)
                .alpha(progress.value)
                .scale(0.8f + progress.value * 0.2f),
        )
        Text(
            text = stringResource(R.string.vzbxv_app_name),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.alpha(progress.value),
        )
    }
}
