package ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions

import ru.mixail_akulov.my.englishtrain.multimodule.core.AppException

class AccountAlreadyExistsException(
    cause: Throwable? = null
) : AppException(cause = cause)