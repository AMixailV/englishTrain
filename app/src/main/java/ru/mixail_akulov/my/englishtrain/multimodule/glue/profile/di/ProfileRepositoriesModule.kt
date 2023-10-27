package ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.repositories.AdapterAuthTokenRepository
import ru.mixail_akulov.my.englishtrain.multimodule.glue.profile.repositories.AdapterProfileRepository
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.AuthTokenRepository
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.repositories.ProfileRepository

@Module
@InstallIn(SingletonComponent::class)
interface ProfileRepositoriesModule {

    @Binds
    fun bindAuthTokenRepository(
        authTokenRepository: AdapterAuthTokenRepository
    ): AuthTokenRepository

    @Binds
    fun bindProfileRepository(
        profileRepository: AdapterProfileRepository
    ): ProfileRepository

}