package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.domain.repositories.GetCurrentUsernameRepository
import javax.inject.Inject

class AdapterGetCurrentUsernameRepository @Inject constructor(
    private val accountsRepository: AccountsDataRepository
) : GetCurrentUsernameRepository {

    override fun getCurrentUsername(): Flow<Container<String>> {
        return accountsRepository.getAccount().map { container ->
            container.map { it.username }
        }
    }

    override fun reload() {
        accountsRepository.reload()
    }

}