package ru.mixail_akulov.my.englishtrain.multimodule

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.mixail_akulov.my.englishtrain.multimodule.core.Core
import ru.mixail_akulov.my.englishtrain.multimodule.core.CoreProvider
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var coreProvider: CoreProvider

    override fun onCreate() {
        super.onCreate()
        Core.init(coreProvider)
    }

}