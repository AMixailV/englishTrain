package ru.mixail_akulov.my.englishtrain.multimodule.profile.domain

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.entities.Profile
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {

    /**
     * Прослушайте информацию профиля текущего вошедшего в систему пользователя.
     * @return бесконечный поток, всегда успех; ошибки передаются в [Container]
     */
    fun getProfile(): Flow<Container<Profile>> {
        return profileRepository.getProfile()
    }

    /**
     * Попробуйте перезагрузить поток профиля, возвращенный [getProfile].
     */
    fun reload() {
        profileRepository.reload()
    }

}