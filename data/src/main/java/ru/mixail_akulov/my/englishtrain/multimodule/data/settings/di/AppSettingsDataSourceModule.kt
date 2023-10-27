package ru.mixail_akulov.my.englishtrain.multimodule.data.settings.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.data.settings.SettingsDataSource
import ru.mixail_akulov.my.englishtrain.multimodule.data.settings.SharedPreferencesSettingsDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppSettingsDataSourceModule {

    @Binds
    @Singleton
    fun bindAppSettingsDataSource(
        settingsDataSource: SharedPreferencesSettingsDataSource
    ): SettingsDataSource

}