package ru.mixail_akulov.my.englishtrain.multimodule.navigation

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.TabsFragment
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.navigation.NavTab

interface DestinationsProvider {

    /**
     * Получите идентификатор назначения начального стартового экрана.
     */
    @IdRes
    fun provideStartDestinationId(): Int

    /**
     * Получите идентификатор основного навигационного графа.
     */
    @NavigationRes
    fun provideNavigationGraphId(): Int

    /**
     * Получите список вкладок, которые будут отображаться на нижней панели навигации.
     */
    fun provideMainTabs(): List<NavTab>

    /**
     * Получите идентификатор назначения [TabsFragment]
     */
    @IdRes
    fun provideTabsDestinationId(): Int

//    /**
//     * Get the destination ID of fragment which shows a cart to the user.
//     */
//    @IdRes
//    fun provideCartDestinationId(): Int

}