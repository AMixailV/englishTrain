package ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories

interface AuthTokenRepository {

    /**
     * Сохраните токен авторизации.
     */
    suspend fun setToken(token: String?)

    /**
     * Получите токен авторизации текущего вошедшего в систему пользователя.
     */
    suspend fun getToken(): String?

}