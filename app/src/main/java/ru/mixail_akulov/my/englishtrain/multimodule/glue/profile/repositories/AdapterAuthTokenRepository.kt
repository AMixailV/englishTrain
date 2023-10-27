package ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.data.settings.SettingsDataSource
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.AuthTokenRepository
import javax.inject.Inject

class AdapterAuthTokenRepository @Inject constructor(
    private val settingsDataSource: SettingsDataSource,
) : AuthTokenRepository {

    override suspend fun clearToken() {
        settingsDataSource.setToken(null)
    }

}