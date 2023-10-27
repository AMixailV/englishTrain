package ru.mixail_akulov.my.englishtrain.multimodule.glue.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signup.AdapterSignUpRouter
import ru.mixail_akulov.my.englishtrain.multimodule.signup.presentation.SignUpRouter

@Module
@InstallIn(ActivityRetainedComponent::class)
interface SignUpRouterModule {

    @Binds
    fun bindSignUpRouter(router: AdapterSignUpRouter): SignUpRouter

}