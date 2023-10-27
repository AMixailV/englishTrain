package ru.mixail_akulov.my.englishtrain.multimodule.navigation

import ru.mixail_akulov.my.englishtrain.multimodule.core.AppRestarter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainAppRestarter @Inject constructor(
    private val globalNavComponentRouter: GlobalNavComponentRouter
) : AppRestarter {

    override fun restartApp() {
        globalNavComponentRouter.restart()
    }

}