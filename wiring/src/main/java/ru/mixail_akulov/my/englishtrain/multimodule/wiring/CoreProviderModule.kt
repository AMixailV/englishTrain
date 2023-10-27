package ru.mixail_akulov.my.englishtrain.multimodule.wiring

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.mixail_akulov.my.englishtrain.multimodule.core.*
import ru.mixail_akulov.my.englishtrain.multimodule.core.impl.ActivityRequired
import ru.mixail_akulov.my.englishtrain.multimodule.core.impl.DefaultCoreProvider
import ru.mixail_akulov.my.englishtrain.multimodule.core.flow.DefaultLazyFlowSubjectFactory
import ru.mixail_akulov.my.englishtrain.multimodule.core.flow.LazyFlowSubjectFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CoreProviderModule {

    @Provides
    fun provideCoreProvider(
        @ApplicationContext context: Context,
        appRestarter: AppRestarter,
    ): CoreProvider {
        return DefaultCoreProvider(
            appContext = context,
            appRestarter = appRestarter
        )
    }

    @Provides
    @ElementsIntoSet
    fun provideActivityRequiredSet(
        commonUi: CommonUi,
        screenCommunication: ScreenCommunication,
    ): Set<@JvmSuppressWildcards ActivityRequired> {
        val set = hashSetOf<ActivityRequired>()
        if (commonUi is ActivityRequired) set.add(commonUi)
        if (screenCommunication is ActivityRequired) set.add(screenCommunication)
        return set
    }

    @Provides
    fun provideScreenCommunication(): ScreenCommunication {
        return Core.screenCommunication
    }

    @Provides
    fun provideCoroutineScope(): CoroutineScope {
        return Core.globalScope
    }

    @Provides
    fun provideCommonUi(): CommonUi {
        return Core.commonUi
    }

    @Provides
    fun provideLogger(): Logger {
        return Core.logger
    }

    @Provides
    fun provideResources(): Resources {
        return Core.resources
    }

    @Provides
    fun provideErrorHandler(): ErrorHandler {
        return Core.errorHandler
    }

    @Provides
    @Singleton
    fun provideLazyFlowSubjectFactory(): LazyFlowSubjectFactory {
        return DefaultLazyFlowSubjectFactory(
            dispatcher = Dispatchers.IO
        )
    }

}