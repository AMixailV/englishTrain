package ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.RealAccountsDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AccountRepositoriesModule {

    @Binds
    @Singleton
    fun bindAccountsRepository(
        accountsDataRepository: RealAccountsDataRepository
    ): AccountsDataRepository

}