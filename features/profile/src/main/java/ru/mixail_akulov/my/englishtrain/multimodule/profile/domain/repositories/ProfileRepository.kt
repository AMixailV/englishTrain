package ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.entities.Profile

interface ProfileRepository {

    /**
     * Прослушайте информацию профиля текущего вошедшего в систему пользователя.
     * @return бесконечный поток, всегда успех; ошибки передаются в [Container]
     */
    fun getProfile(): Flow<Container<Profile>>

    /**
     * Перезагрузить поток информации профиля, возвращенный [getProfile]
     */
    fun reload()

    /**
     * Обновить имя пользователя текущего вошедшего в систему пользователя.
     */
    suspend fun editUsername(newUsername: String)

}