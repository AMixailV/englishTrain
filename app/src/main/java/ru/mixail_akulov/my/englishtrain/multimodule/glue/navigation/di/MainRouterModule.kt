package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.DefaultMainRouter
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.MainRouter

@Module
@InstallIn(ActivityRetainedComponent::class)
interface MainRouterModule {

    @Binds
    fun bindMainRouter(router: DefaultMainRouter): MainRouter

}