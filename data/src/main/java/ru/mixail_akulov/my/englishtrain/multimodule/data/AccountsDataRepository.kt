package ru.mixail_akulov.my.englishtrain.multimodule.data

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.AccountDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.SignUpDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.exceptions.AccountAlreadyExistsDataException

interface AccountsDataRepository {

    /**
     * Прослушайте текущий счет.
     * @return бесконечный поток, всегда успех; ошибки доставляются в [Container]
     */
    fun getAccount(): Flow<Container<AccountDataEntity>>

    /**
     * Обновите имя пользователя текущего вошедшего в систему пользователя.
     */
    suspend fun setAccountUsername(username: String)

    /**
     * Обменяйте пароль электронной почты на токен авторизации.
     */
    suspend fun signIn(email: String, password: String): String

    /**
     * Создать новый аккаунт.
     * @throws AccountAlreadyExistsDataException
     */
    suspend fun signUp(signUpData: SignUpDataEntity)

    /**
     * Перезагрузите поток, возвращенный[getAccount]
     */
    fun reload()

}