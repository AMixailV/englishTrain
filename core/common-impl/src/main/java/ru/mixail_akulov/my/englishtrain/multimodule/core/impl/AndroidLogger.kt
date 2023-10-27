package ru.mixail_akulov.my.englishtrain.multimodule.core.impl

import android.util.Log
import ru.mixail_akulov.my.englishtrain.multimodule.core.Logger

/**
 * Реализация по умолчанию [Logger], которая отправляет все журналы в LogCat.
 */
class AndroidLogger : Logger {

    override fun log(message: String) {
        Log.d("AndroidLogger", message)
    }

    override fun err(exception: Throwable, message: String?) {
        Log.e("AndroidLogger", message, exception)
    }

}