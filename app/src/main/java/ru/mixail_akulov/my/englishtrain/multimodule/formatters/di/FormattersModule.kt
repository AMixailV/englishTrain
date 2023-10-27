package ru.mixail_akulov.my.englishtrain.multimodule.formatters.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.formatters.DateTimeFormatter
import ru.mixail_akulov.my.englishtrain.multimodule.formatters.DefaultDateTimeFormatter

@Module
@InstallIn(SingletonComponent::class)
interface FormattersModule {

    @Binds
    fun bindDateTimeFormatter(
        formatter: DefaultDateTimeFormatter
    ): DateTimeFormatter
}