package smyerb.autoparts.smyerbautoroute.data.repository

import smyerb.autoparts.smyerbautoroute.data.datastore.VZBXVOnboardingPrefs
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class VZBXVOnboardingRepo(
    private val vzbxvOnboardingStoreManager: VZBXVOnboardingPrefs,
    private val coroutineDispatcher: CoroutineDispatcher,
) {

    fun observeOnboardingState(): Flow<Boolean?> {
        return vzbxvOnboardingStoreManager.onboardedStateFlow
    }

    suspend fun setOnboardingState(state: Boolean) {
        withContext(coroutineDispatcher) {
            vzbxvOnboardingStoreManager.setOnboardedState(state)
        }
    }
}