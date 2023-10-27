package ru.mixail_akulov.my.englishtrain.multimodule.glue.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mixail_akulov.my.englishtrain.multimodule.glue.signup.repositories.AdapterSignUpRepository
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.repositories.SignUpRepository

@Module
@InstallIn(SingletonComponent::class)
interface SignUpRepositoriesModule {

    @Binds
    fun bindSignUpDataSource(signUpDataSource: AdapterSignUpRepository): SignUpRepository

}