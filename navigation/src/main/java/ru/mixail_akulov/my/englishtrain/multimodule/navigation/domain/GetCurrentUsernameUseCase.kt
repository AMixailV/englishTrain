package ru.mixail_akulov.my.englishtrain.multimodule.navigation.domain

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.domain.repositories.GetCurrentUsernameRepository
import javax.inject.Inject

class GetCurrentUsernameUseCase @Inject constructor(
    private val getCurrentUsernameRepository: GetCurrentUsernameRepository
) {

    /**
     * Прослушайте имя текущего вошедшего в систему пользователя.
     * @return бесконечный поток, всегда успех; ошибки передаются в[Container]
     */
    fun getUsername(): Flow<Container<String>> {
        return getCurrentUsernameRepository.getCurrentUsername()
    }

}