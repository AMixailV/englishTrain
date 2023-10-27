package ru.mixail_akulov.my.englishtrain.multimodule.navigation.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container

interface GetCurrentUsernameRepository {

    /**
     * Прослушайте имя текущего вошедшего в систему пользователя.
     * @return бесконечный поток, всегда успех; ошибки передаются в [Container]
     */
    fun getCurrentUsername(): Flow<Container<String>>

    /**
     * Перезагрузить поток имени пользователя, возвращенный [getCurrentUsername]
     */
    fun reload()

}