package ru.mixail_akulov.my.englishtrain.multimodule.glue.navigation

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.mixail_akulov.my.englishtrain.multimodule.R
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.DestinationsProvider
import ru.mixail_akulov.my.englishtrain.multimodule.navigation.presentation.navigation.NavTab
import javax.inject.Inject

class DefaultDestinationsProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : DestinationsProvider {

    override fun provideStartDestinationId(): Int {
        return R.id.signInFragment
    }

    override fun provideNavigationGraphId(): Int {
        return R.navigation.nav_graph
    }

    override fun provideMainTabs(): List<NavTab> {
        return listOf(
            NavTab(
                destinationId = R.id.homeFragment,
                title = context.getString(R.string.tab_home),
                iconRes = R.drawable.ic_home,
            ),
            NavTab(
                destinationId = R.id.profileFragment,
                title = context.getString(R.string.tab_profile),
                iconRes = R.drawable.ic_profile,
            )
        )
    }

    override fun provideTabsDestinationId(): Int {
        return R.id.tabsFragment
    }
}