package ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.AdapterProfileRouter
import ru.mixail_akulov.my.englishtrain.multimodule.profile.presentation.ProfileRouter

@Module
@InstallIn(ActivityRetainedComponent::class)
interface ProfileRouterModule {

    @Binds
    fun bindProfileRouter(
        profileRouter: AdapterProfileRouter,
    ): ProfileRouter

}