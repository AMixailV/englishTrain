package ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.exceptions

import ru.mixail_akulov.my.englishtrain.multimodule.core.AppException
import ru.mixail_akulov.my.englishtrain.multimodule.signup.domain.entities.SignUpField

class EmptyFieldException(
    val field: SignUpField,
) : AppException()