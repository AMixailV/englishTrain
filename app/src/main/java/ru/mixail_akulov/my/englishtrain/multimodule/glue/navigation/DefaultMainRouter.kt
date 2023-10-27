package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation

import ru.mixail_akulov.my.englishtrain.multimodule.navigation.GlobalNavComponentRouter
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.MainRouter
import javax.inject.Inject

class DefaultMainRouter @Inject constructor(
    private val navComponentRouter: GlobalNavComponentRouter
) : MainRouter {

    override fun launchCart() {
//        navComponentRouter.launch(R.id.cartListFragment)
    }

}