package ru.mixail_akulov.my.englishtrain.multimodule.core

import kotlinx.coroutines.runBlocking

/**
 * Представляет текущий статус асинхронной операции выборки.
 * @see Container.Pending
 * @see Container.Error
 * @see Container.Success
 */
sealed class Container<out T> {

    /**
     * Преобразуйте тип контейнера в другой тип.
     */
    fun <R> map(mapper: ((T) -> R)? = null): Container<R> {
        return runBlocking {
            val suspendMapper: (suspend (T) -> R)? = if (mapper == null) {
                null
            } else {
                {
                    mapper(it)
                }
            }
            suspendMap(suspendMapper)
        }
    }

    /**
     * Преобразуйте тип контейнера в другой тип с помощью лямбда-функции приостановки.
     */
    abstract suspend fun <R> suspendMap(mapper: (suspend (T) -> R)? = null): Container<R>

    /**
     * Получите значение, поддерживаемое контейнером, если это возможно, или выдайте исключение.
     */
    abstract fun unwrap(): T

    /**
     * Получите значение, поддерживаемое контейнером, если это возможно, или верните null.
     */
    abstract fun getOrNull(): T?

    /**
     * Операция все еще продолжается.
     */
    object Pending : Container<Nothing>() {

        override suspend fun <R> suspendMap(mapper: (suspend (Nothing) -> R)?): Container<R> {
            return this
        }

        override fun unwrap(): Nothing {
            throw IllegalStateException("Container is Pending")
        }

        override fun getOrNull(): Nothing? {
            return null
        }
    }

    /**
     * Операция не удалась.
     */
    data class Error(
        val exception: Exception
    ) : Container<Nothing>() {

        override suspend fun <R> suspendMap(mapper: (suspend (Nothing) -> R)?): Container<R> {
            return this
        }

        override fun unwrap(): Nothing {
            throw exception
        }

        override fun getOrNull(): Nothing? {
            return null
        }
    }

    /**
     * Операция завершена успешно.
     */
    data class Success<T>(
        val value: T
    ) : Container<T>() {

        override suspend fun <R> suspendMap(mapper: (suspend (T) -> R)?): Container<R> {
            if (mapper == null) throw IllegalStateException("Can't map Container.Success without mapper")
            return try {
                Success(mapper(value))
            } catch (e: Exception) {
                Error(e)
            }
        }

        override fun unwrap(): T {
            return value
        }

        override fun getOrNull(): T? {
            return value
        }
    }

}
