package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.AuthServiceRepository
import javax.inject.Inject

class AdapterAuthServiceRepository @Inject constructor(
    private val accountsDataRepository: AccountsDataRepository,
) : AuthServiceRepository {

    override suspend fun signIn(email: String, password: String): String {
        return accountsDataRepository.signIn(email, password)
    }

}