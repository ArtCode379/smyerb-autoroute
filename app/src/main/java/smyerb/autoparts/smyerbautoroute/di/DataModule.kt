package smyerb.autoparts.smyerbautoroute.di

import smyerb.autoparts.smyerbautoroute.data.repository.CartRepository
import smyerb.autoparts.smyerbautoroute.data.repository.VZBXVOnboardingRepo
import smyerb.autoparts.smyerbautoroute.data.repository.OrderRepository
import smyerb.autoparts.smyerbautoroute.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        VZBXVOnboardingRepo(
            vzbxvOnboardingStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}