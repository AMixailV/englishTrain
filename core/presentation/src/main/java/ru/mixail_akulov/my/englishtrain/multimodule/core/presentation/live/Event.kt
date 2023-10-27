package ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.live

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Одноразовое событие с побочным эффектом, которое будет использоваться в [LiveValue] или [LiveData].
 */
class Event<T>(
    value: T
) {

    private var _value: T? = value

    fun get(): T? = _value.also { _value = null }

}

/**
 * Краткое название актуальной ценности с событием.
 */
typealias LiveEventValue<T> = LiveValue<Event<T>>

/**
 * Метод расширения для более простого наблюдения за событиями.
 */
fun <T> LiveValue<Event<T>>.observeEvent(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
    observe(lifecycleOwner) { event ->
        val value = event.get() ?: return@observe
        observer(value)
    }
}