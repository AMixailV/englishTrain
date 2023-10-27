package ru.mixail_akulov.my.englishtrain.multimodule.data.accounts

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.mixail_akulov.my.englishtrain.multimodule.core.AuthException
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.core.flow.LazyFlowSubjectFactory
import ru.mixail_akulov.my.englishtrain.multimodule.data.AccountsDataRepository
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.AccountDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.entities.SignUpDataEntity
import ru.mixail_akulov.my.englishtrain.multimodule.data.accounts.sources.AccountsDataSource
import ru.mixail_akulov.my.englishtrain.multimodule.data.settings.SettingsDataSource
import javax.inject.Inject

class RealAccountsDataRepository @Inject constructor(
    private val accountsDataSource: AccountsDataSource,
    private val settingsDataSource: SettingsDataSource,
    coroutineScope: CoroutineScope,
    lazyFlowSubjectFactory: LazyFlowSubjectFactory,
) : AccountsDataRepository {

    private val accountLazyFlowSubject = lazyFlowSubjectFactory.create {
        accountsDataSource.getAccount()
    }

    init {
        coroutineScope.launch {
            settingsDataSource.listenToken().collect {
                if (it != null) {
                    accountLazyFlowSubject.newAsyncLoad(silently = true)
                } else {
                    accountLazyFlowSubject.updateWith(Container.Error(AuthException()))
                }
            }
        }
    }

    override fun getAccount(): Flow<Container<AccountDataEntity>> {
        return accountLazyFlowSubject.listen()
    }

    override suspend fun setAccountUsername(username: String) {
        val newAccount = accountsDataSource.setAccountUsername(username)
        accountLazyFlowSubject.updateWith(Container.Success(newAccount))
    }

    override suspend fun signIn(email: String, password: String): String {
        return accountsDataSource.signIn(email, password)
    }

    override suspend fun signUp(signUpData: SignUpDataEntity) {
        accountsDataSource.signUp(signUpData)
    }

    override fun reload() {
        accountLazyFlowSubject.newAsyncLoad()
    }

}