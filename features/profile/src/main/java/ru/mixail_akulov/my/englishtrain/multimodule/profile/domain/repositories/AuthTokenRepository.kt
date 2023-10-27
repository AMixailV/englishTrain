package ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories

interface AuthTokenRepository {

    /**
     * Очистить токен авторизации, сохраненный в приложении.
     */
    suspend fun clearToken()

}