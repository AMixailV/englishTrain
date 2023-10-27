package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation.DefaultDestinationsProvider
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.DestinationsProvider

@Module
@InstallIn(SingletonComponent::class)
interface StartDestinationProviderModule {

    @Binds
    fun bindStartDestinationProvider(
        startDestinationProvider: DefaultDestinationsProvider
    ): DestinationsProvider

}