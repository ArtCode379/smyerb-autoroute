package smyerb.autoparts.smyerbautoroute.di

import smyerb.autoparts.smyerbautoroute.ui.viewmodel.AppViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.CartViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.CheckoutViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.VZBXVOnboardingVM
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.OrderViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.ProductDetailsViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.ProductViewModel
import smyerb.autoparts.smyerbautoroute.ui.viewmodel.VZBXVSplashVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        VZBXVSplashVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        VZBXVOnboardingVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}