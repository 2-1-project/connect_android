package com.second.connect

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.second.connect.ui.share.ShareScreen
import com.second.connect.ui.theme.White

sealed class BottomNavItem(
    val screenRoute: String,
    val unselectIcon: Int,
    val selectIcon: Int
) {
    object Share : BottomNavItem(SHARE, R.drawable.share_unselect, R.drawable.share_select)
}

const val MY_CARD = "MY_CARD"
const val SHARE = "SHARE"
const val CONNECTS = "CONNECTS"
const val MY_PAGE = "MY_PAGE"

@Composable
fun ConnectGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Share.screenRoute
    ) {
        composable(BottomNavItem.Share.screenRoute) {
            ShareScreen()
        }
    }
}

@Composable
fun ConnectBottomNavigation(
    navController: NavController
) {
    val navItems = listOf<BottomNavItem>(
        BottomNavItem.Share
    )

    androidx.compose.material3.NavigationBar(
        containerColor = White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { navItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if(navItem.screenRoute == currentRoute) navItem.selectIcon else navItem.unselectIcon),
                        contentDescription = null
                    )
                },
                selected = currentRoute == navItem.screenRoute,
                onClick = {
                    navController.navigate(navItem.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {saveState = true}
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}