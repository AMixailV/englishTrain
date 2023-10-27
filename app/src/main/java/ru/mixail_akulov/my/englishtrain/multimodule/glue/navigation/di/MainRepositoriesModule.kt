package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.repositories.AdapterGetCurrentUsernameRepository
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.domain.repositories.GetCurrentUsernameRepository

@Module
@InstallIn(SingletonComponent::class)
interface MainRepositoriesModule {

    @Binds
    fun bindGetCurrentUsernameRepository(
        getCurrentUsernameRepository: AdapterGetCurrentUsernameRepository
    ): GetCurrentUsernameRepository

}