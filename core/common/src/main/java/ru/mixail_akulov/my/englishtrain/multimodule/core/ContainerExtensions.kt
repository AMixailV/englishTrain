package ru.mixail_akulov.my.englishtrain.multimodule.core

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withTimeout

/**
 * Попробуйте получить первое неожидающее значение из потока, испускающего объекты [Container].
 *
 * Возвращает первый экземпляр [T], созданный потоком в течение указанного [timeoutMillis].
 *
 * Выдает исключение из контейнера, если последний имеет значение [Container.Error].
 *
 * Выдает [TimeoutCancellationException], если поток не выдал значение успеха или ошибки
 * в течение [timeoutMillis] миллисекунд.
 */

suspend fun <T> Flow<Container<T>>.unwrapFirst(timeoutMillis: Long = Core.remoteTimeoutMillis): T {
    return withTimeout(timeoutMillis) {
        filterNot { it is Container.Pending }
            .first()
            .unwrap()
    }
}