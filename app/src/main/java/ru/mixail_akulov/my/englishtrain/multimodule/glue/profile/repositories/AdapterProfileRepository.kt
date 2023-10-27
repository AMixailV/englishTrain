package ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.formatters.DateTimeFormatter
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.entities.Profile
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.ProfileRepository
import javax.inject.Inject

class AdapterProfileRepository @Inject constructor(
    private val accountsDataRepository: AccountsDataRepository,
    private val dateTimeFormatter: DateTimeFormatter,
) : ProfileRepository {

    override fun getProfile(): Flow<Container<Profile>> {
        return accountsDataRepository.getAccount().map { container ->
            container.map {
                Profile(
                    id = it.id,
                    username = it.username,
                    email = it.email,
                    createdAtString = dateTimeFormatter.formatDateTime(it.createdAtMillis)
                )
            }
        }
    }

    override fun reload() {
        accountsDataRepository.reload()
    }

    override suspend fun editUsername(newUsername: String) {
        accountsDataRepository.setAccountUsername(newUsername)
    }

}