package ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.live

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.BaseViewModel

/**
 * Обертка для значения, которое можно наблюдать в рамках указанного жизненного цикла.
 * Обычно используется вместо [LiveData] в сочетании с [BaseViewModel],
 * чтобы избежать дублирования LiveData. Например. вы можете написать это:
 *
 * ```
 * val userLiveValue = liveValue<User>()
 * ```
 *
 * instead of this:
 *
 * ```
 * private val _userLiveData = MutableLiveData<User>()
 * val userLiveData: LiveData<User> = _userLiveData
 * ```
 *
 */
interface LiveValue<T> {

    fun observe(lifecycleOwner: LifecycleOwner, listener: (T) -> Unit)

    fun requireValue(): T

    fun getValue(): T?

}