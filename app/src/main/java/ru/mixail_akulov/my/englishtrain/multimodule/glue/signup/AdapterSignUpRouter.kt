package ru.mixail_akulov.my.englishtrain.multimodule.glue.signup

import ru.mixail_akulov.my.englishtrain.multimodule.navigation.GlobalNavComponentRouter
import ru.mixail_akulov.my.englishtrain.multimodule.signup.presentation.SignUpRouter
import javax.inject.Inject

class AdapterSignUpRouter @Inject constructor(
    private val globalNavComponentRouter: GlobalNavComponentRouter
) : SignUpRouter {

    override fun goBack() {
        globalNavComponentRouter.pop()
    }

}