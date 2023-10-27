package ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.assignable

import ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.live.LiveValue
import ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.live.MutableLiveValue

internal class LiveValueAssignable<T>(
    private val liveValue: LiveValue<T>
) : Assignable<T> {

    override fun setValue(value: T) {
        (liveValue as? MutableLiveValue<T>)?.setValue(value)
    }
}