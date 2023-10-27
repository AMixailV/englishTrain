package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Глобальный обработчик ошибок по умолчанию для действий, выполняемых обычно через viewModelScope.
 */
interface ErrorHandler {

    fun handleError(exception: Throwable)

    fun getUserMessage(exception: Throwable): String

}