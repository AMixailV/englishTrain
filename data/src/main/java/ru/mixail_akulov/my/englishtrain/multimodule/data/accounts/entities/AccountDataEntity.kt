package ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities

data class AccountDataEntity(
    val id: Long,
    val email: String,
    val username: String,
    val createdAtMillis: Long
)