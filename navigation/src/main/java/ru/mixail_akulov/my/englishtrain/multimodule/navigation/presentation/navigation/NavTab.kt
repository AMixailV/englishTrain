package ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

class NavTab(

    /**
     * Идентификатор назначения, который запускается, когда пользователь нажимает на эту вкладку.
     */
    @IdRes val destinationId: Int,

    /**
     * Название вкладки отображается под значком.
     */
    val title: String,

    /**
     * Значок вкладки.
     */
    @DrawableRes val iconRes: Int

) : java.io.Serializable
