package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories.AdapterAuthServiceRepository
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories.AdapterAuthTokenRepository
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signin.repositories.AdapterProfileRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.AuthServiceRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.AuthTokenRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signin.domain.repositories.ProfileRepository

@Module
@InstallIn(SingletonComponent::class)
interface SignInRepositoriesModule {

    @Binds
    fun bindAuthRepository(
        authServiceRepository: AdapterAuthServiceRepository
    ): AuthServiceRepository

    @Binds
    fun bindAuthTokenRepository(
        authTokenRepository: AdapterAuthTokenRepository
    ): AuthTokenRepository

    @Binds
    fun bindProfileRepository(
        profileRepository: AdapterProfileRepository
    ): ProfileRepository

}