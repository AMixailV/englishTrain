package ru.mixail_akulov.my.englishtrain.multimodule.profile.domain

import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.AuthTokenRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authTokenRepository: AuthTokenRepository,
) {

    /**
     * Выход из приложения.
     */
    suspend fun logout() {
        authTokenRepository.clearToken()
    }

}