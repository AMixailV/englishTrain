package ru.mixail_akulov.my.englishtrain.multimodule.signup.domain

import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities.SignUpData
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities.SignUpField
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions.AccountAlreadyExistsException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions.EmptyFieldException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions.PasswordMismatchException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.repositories.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
) {

    /**
     * Создать новый аккаунт.
     * @throws EmptyFieldException
     * @throws AccountAlreadyExistsException
     * @throws PasswordMismatchException
     */
    suspend fun signUp(signUpData: SignUpData) {
        if (signUpData.email.isBlank()) throw EmptyFieldException(SignUpField.EMAIL)
        if (signUpData.username.isBlank()) throw EmptyFieldException(SignUpField.USERNAME)
        if (signUpData.password.isBlank()) throw EmptyFieldException(SignUpField.PASSWORD)
        if (signUpData.repeatPassword.isBlank()) throw EmptyFieldException(SignUpField.REPEAT_PASSWORD)
        if (signUpData.password != signUpData.repeatPassword) throw PasswordMismatchException()

        signUpRepository.signUp(signUpData)
    }

}