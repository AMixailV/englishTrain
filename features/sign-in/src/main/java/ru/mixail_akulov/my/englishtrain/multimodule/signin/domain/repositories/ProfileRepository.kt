package ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories

interface ProfileRepository {

    /**
     * Можно ли загрузить профиль текущего вошедшего в систему пользователя или нет.
     */
    suspend fun canLoadProfile(): Boolean

}