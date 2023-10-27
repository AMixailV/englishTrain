package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Глобальный регистратор в приложении.
 */
interface Logger {

    fun log(message: String)

    fun err(exception: Throwable, message: String? = null)

}