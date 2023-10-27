package ru.mixail_akulov.my.englishtrain.multimodule.glue.profile

import ru.mixail_akulov.my.englishtrain.multimodule.R
import ru.mixail_akulov.my.englishtrain.multimodule.core.AppRestarter
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.GlobalNavComponentRouter
import ru.mixail_akulov.my.englishtrain.multimodule.profile.presentation.ProfileRouter
import javax.inject.Inject

class AdapterProfileRouter @Inject constructor(
    private val appRestarter: AppRestarter,
    private val globalNavComponentRouter: GlobalNavComponentRouter,
) : ProfileRouter {

    override fun launchEditUsername() {
        globalNavComponentRouter.launch(R.id.editUsernameFragment)
    }

    override fun goBack() {
        globalNavComponentRouter.pop()
    }

    override fun restartApp() {
        appRestarter.restartApp()
    }
}