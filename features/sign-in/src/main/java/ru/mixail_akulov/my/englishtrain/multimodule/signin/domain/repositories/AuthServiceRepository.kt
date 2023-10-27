package ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories

interface AuthServiceRepository {

    /**
     * Замените пару электронной почты и пароля на токен аутентификации.
     */
    suspend fun signIn(email: String, password: String): String

}