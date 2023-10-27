package ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities.SignUpData
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions.AccountAlreadyExistsException

interface SignUpRepository {

    /**
     * @throws AccountAlreadyExistsException если пользователь с указанным адресом электронной почты уже существует
     */
    suspend fun signUp(signUpData: SignUpData)

}