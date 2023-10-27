package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.core.AuthException
import ru.mixail_akulov.my.englishtrain.multimodule.core.unwrapFirst
import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.ProfileRepository
import javax.inject.Inject

class AdapterProfileRepository @Inject constructor(
    private val accountsDataRepository: AccountsDataRepository,
) : ProfileRepository {

    override suspend fun canLoadProfile(): Boolean {
        return try {
            accountsDataRepository.getAccount().unwrapFirst()
            true
        } catch (ignored: AuthException) {
            false
        }
    }
}