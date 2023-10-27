package ru.mixail_akulov.my.englishtrain.multimodule.core

/**
 * Любые управляемые исключения в приложении.
 */
open class AppException(
    message: String = "",
    cause: Throwable? = null,
) : Exception(message, cause)

/**
 * Проблемы с интернет-соединением
 */
class ConnectionException(cause: Exception) : AppException(cause = cause)

/**
 * Проблемы с удаленным обслуживанием
 */
open class RemoteServiceException(
    message: String,
    cause: Exception? = null
) : AppException(message, cause)

/**
 * Проблемы аутентификации.
 */
class AuthException(cause: Exception? = null) : AppException(cause = cause)

/**
 * Проблемы с чтением записи данных в локальное хранилище.
 */
class StorageException(cause: Exception) : AppException(cause = cause)

/**
 * Исключение с удобным для пользователя сообщением, которое можно безопасно отобразить пользователю.
 */
class UserFriendlyException(
    val userFriendlyMessage: String,
    cause: Exception,
) : AppException(cause.message ?: "", cause)

/**
 * Что-то не существует
 */
class NotFoundException : AppException()
