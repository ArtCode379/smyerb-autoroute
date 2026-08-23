package smyerb.autoparts.smyerbautoroute.di

import smyerb.autoparts.smyerbautoroute.data.datastore.VZBXVOnboardingPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { VZBXVOnboardingPrefs(androidContext()) }
}