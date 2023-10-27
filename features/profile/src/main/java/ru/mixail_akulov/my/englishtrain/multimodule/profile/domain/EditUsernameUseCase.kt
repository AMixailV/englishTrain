package ru.mixail_akulov.my.englishtrain.multimodule.profile.domain

import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.exceptions.EmptyUsernameException
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.ProfileRepository
import javax.inject.Inject

class EditUsernameUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    /**
     * Обновите имя пользователя текущего вошедшего в систему пользователя.
     * @throws EmptyUsernameException
     */
    suspend fun editUsername(newUsername: String) {
        if (newUsername.isBlank()) throw EmptyUsernameException()
        profileRepository.editUsername(newUsername)
    }

}