package ru.mixail_akulov.my.englishtrain.multimodule.glue.signup.repositories

import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.SignUpDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.exceptions.AccountAlreadyExistsDataException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities.SignUpData
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions.AccountAlreadyExistsException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.repositories.SignUpRepository
import javax.inject.Inject

class AdapterSignUpRepository @Inject constructor(
    private val accountsRepository: AccountsDataRepository
) : SignUpRepository {

    override suspend fun signUp(signUpData: SignUpData) {
        try {
            accountsRepository.signUp(
                SignUpDataEntity(
                    email = signUpData.email,
                    username = signUpData.username,
                    password = signUpData.password,
                )
            )
        } catch (e: AccountAlreadyExistsDataException) {
            throw AccountAlreadyExistsException(e)
        }
    }

}