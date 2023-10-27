package ru.mixail_akulov.my.englishtrain.multimodule.core.flow

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import ru.mixail_akulov.my.englishtrain.multimodule.core.Core

class DefaultLazyFlowSubjectFactory(
    private val dispatcher: CoroutineDispatcher,
    private val globalScope: CoroutineScope = Core.globalScope,
    private val cacheTimeoutMillis: Long = 1000
) : LazyFlowSubjectFactory {

    override fun <T> create(loader: ValueLoader<T>): LazyFlowSubject<T> {
        return DefaultLazyFlowSubject(loader, dispatcher, globalScope, cacheTimeoutMillis)
    }

}