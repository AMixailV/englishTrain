package ru.mixail_akulov.my.englishtrain.multimodule.core.flow

import kotlinx.coroutines.flow.Flow
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container

/**
 * Функция загрузчика для[LazyFlowSubject].
 */
typealias ValueLoader<T> = suspend () -> T

/**
 * Асинхронный контейнер для загрузки данных и прослушивания текущего состояния процесса загрузки.
 *
 * Загрузчик значений обычно задается функцией [ValueLoader],
 * передаваемой в [LazyFlowSubjectFactory.create] в качестве аргумента.
 *
 * Загрузчик начинает лениво загружать значение,
 * когда хотя бы один подписчик начинает собирать поток, возвращаемый методом [listen].
 *
 * Загрузчику значений можно назначить новый с помощью методов [newLoad] и [newAsyncLoad].
 * В этом случае старая загрузка отменяется и заменяется новой.
 *
 * Также можно обновить значение напрямую, вызвав метод [updateWith].
 */
interface LazyFlowSubject<T> {

    /**
     * Прослушайте значения, загруженные этим субъектом. Значение загружается автоматически,
     * когда хотя бы 1 подписчик начинает собирать возвращаемый поток.
     */
    fun listen(): Flow<Container<T>>

    /**
     * Запустите новую загрузку, которая заменит существующее значение в потоке, возвращаемом [listen].
     */
    suspend fun newLoad(silently: Boolean = false, valueLoader: ValueLoader<T>? = null): T

    /**
     * То же, что и [newLoad], но не ждать результата загрузки.
     */
    fun newAsyncLoad(silently: Boolean = false, valueLoader: ValueLoader<T>? = null)

    /**
     * Немедленно обновите значение в потоке, возвращаемом [listen]
     */
    fun updateWith(container: Container<T>)

    /**
     * Немедленно обновите значение в потоке, возвращаемом [listen], с помощью
     * функции [updater], которая принимает старое значение в качестве аргументов.
     */
    fun updateWith(updater: (Container<T>) -> Container<T>)

}