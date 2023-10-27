package ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities

data class SignUpData(
    val email: String,
    val username: String,
    val password: String,
    val repeatPassword: String,
)