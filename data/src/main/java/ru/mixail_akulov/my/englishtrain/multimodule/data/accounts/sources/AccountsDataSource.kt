package ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.sources

import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.AccountDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.SignUpDataEntity

interface AccountsDataSource {

    suspend fun signIn(email: String, password: String): String

    suspend fun signUp(signUpData: SignUpDataEntity)

    suspend fun getAccount(): AccountDataEntity

    suspend fun setAccountUsername(username: String): AccountDataEntity

}