package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.data.settings.SettingsDataSource
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.AuthTokenRepository
import javax.inject.Inject

class AdapterAuthTokenRepository @Inject constructor(
    private val settingsDataSource: SettingsDataSource,
) : AuthTokenRepository {

    override suspend fun setToken(token: String?) {
        settingsDataSource.setToken(token)
    }

    override suspend fun getToken(): String? {
        return settingsDataSource.getToken()
    }
}