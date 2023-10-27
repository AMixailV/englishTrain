package ru.mixail_akulov.my.englishtrain.multimodule.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.mixail_akulov.my.englishtrain.multimodule.core.AppRestarter
import ru.mixail_akulov.my.englishtrain.multimodule.core.impl.ActivityRequired
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.GlobalNavComponentRouter
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.MainAppRestarter

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Provides
    fun provideAppRestarter(
        appRestarter: MainAppRestarter
    ): AppRestarter {
        return appRestarter
    }

    @Provides
    @IntoSet
    fun provideRouterAsActivityRequired(
        router: GlobalNavComponentRouter,
    ): ActivityRequired {
        return router
    }


}