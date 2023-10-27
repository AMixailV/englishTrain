package ru.mixail_akulov.my.englishtrain.multimodule.signin.domain

import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.AuthTokenRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.ProfileRepository
import javax.inject.Inject

class IsSignedInUseCase @Inject constructor(
    private val authTokenRepository: AuthTokenRepository,
    private val profileRepository: ProfileRepository,
) {

    /**
     * Вошел ли пользователь в систему или нет.
     */
    suspend fun isSignedIn(): Boolean {
        return authTokenRepository.getToken() != null
                && profileRepository.canLoadProfile()
    }

}