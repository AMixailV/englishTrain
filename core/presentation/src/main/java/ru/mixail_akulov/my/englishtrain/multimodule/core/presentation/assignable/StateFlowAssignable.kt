package ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.assignable

import kotlinx.coroutines.flow.MutableStateFlow

internal class StateFlowAssignable<T>(
    private val stateFlow: MutableStateFlow<T>
) : Assignable<T> {

    override fun setValue(value: T) {
        stateFlow.value = value
    }

}