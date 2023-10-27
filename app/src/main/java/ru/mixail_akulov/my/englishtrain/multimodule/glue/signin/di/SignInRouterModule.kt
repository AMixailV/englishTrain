package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.AdapterSignInRouter
import ru.mixail_akulov.my.englishtrain.multimodule.signin.presentation.SignInRouter

@Module
@InstallIn(ActivityRetainedComponent::class)
interface SignInRouterModule {

    @Binds
    fun bindSignInRouter(router: AdapterSignInRouter): SignInRouter

}