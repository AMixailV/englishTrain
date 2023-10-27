package ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.navigation


sealed class NavigationMode : java.io.Serializable {

    /**
     * Простая навигация по стеку
     */
    object Stack : NavigationMode()

    /**
     * Простая навигация по стеку, но начальный экран содержит нижние вкладки, определенные в аргументе [tabs].
     */
    class Tabs(
        val tabs: ArrayList<NavTab>,
        val startTabDestinationId: Int?,
    ) : NavigationMode()

}