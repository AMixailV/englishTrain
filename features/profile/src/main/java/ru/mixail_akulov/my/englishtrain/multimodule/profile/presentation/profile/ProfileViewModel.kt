package ru.mixail_akulov.my.englishtrain.multimodule.profile.presentation.profile

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.mixail_akulov.my.englishtrain.multimodule.core.Container
import ru.mixail_akulov.my.englishtrain.multimodule.core.presentation.BaseViewModel
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.GetProfileUseCase
import ru.mixail_akulov.my.englishtrain.multimodule.profile.domain.LogoutUseCase
import ru.mixail_akulov.my.englishtrain.multimodule.profile.presentation.ProfileRouter
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val router: ProfileRouter,
) : BaseViewModel() {

    val profileLiveValue = getProfileUseCase.getProfile()
        .toLiveValue(Container.Pending)

    fun reload() = debounce {
        getProfileUseCase.reload()
    }

    fun logout() = debounce {
        viewModelScope.launch {
            logoutUseCase.logout()
            router.restartApp()
        }
    }

    fun editUsername() = debounce {
        router.launchEditUsername()
    }

}