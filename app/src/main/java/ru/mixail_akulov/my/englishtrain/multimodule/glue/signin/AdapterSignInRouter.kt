package ru.mixail_akulov.my.englishtrain.multimodule.glue.signin

import ru.mixail_akulov.my.englishtrain.multimodule.R
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.GlobalNavComponentRouter
import ru.mixail_akulov.my.englishtrain.multimodule.signin.presentation.SignInRouter
import ru.mixail_akulov.my.englishtrain.multimodule.signup.presentation.signup.SignUpFragment
import javax.inject.Inject

class AdapterSignInRouter @Inject constructor(
    private val globalNavComponentRouter: GlobalNavComponentRouter
) : SignInRouter {

    override fun launchSignUp(email: String) {
        val screen = SignUpFragment.Screen(email)
        globalNavComponentRouter.launch(R.id.signUpFragment, screen)
    }

    override fun launchMain() {
        globalNavComponentRouter.startTabs()
    }

}