package ru.mixail_akulov.my.englishtrain.multimodule.core

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

typealias ScreenResultListener<T> = (T) -> Unit

interface ScreenCommunication {

    /**
     * Зарегистрируйте прослушиватель для указанного результата на экране [clazz].
     */
    fun <T : Any> registerListener(clazz: Class<T>, listener: ScreenResultListener<T>)

    /**
     * Отменить регистрацию указанного слушателя.
     */
    fun <T : Any> unregisterListener(listener: ScreenResultListener<T>)

    /**
     * Отправьте результат экрана первому приемлемому слушателю.
     */
    fun <T : Any> publishResult(result: T)

}

/**
 * Метод расширения для прослушивания результатов экрана с использованием
 * Kotlin Flow вместо простых обратных вызовов.
 */
fun <T : Any> ScreenCommunication.listen(clazz: Class<T>): Flow<T> = callbackFlow {
    val listener: ScreenResultListener<T> = { result ->
        trySend(result)
    }
    registerListener(clazz, listener)
    awaitClose {
        unregisterListener(listener)
    }
}