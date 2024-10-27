package com.second.connect.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.second.connect.R
import com.second.connect.ui.mypage.InquiryScreen
import com.second.connect.ui.mypage.MyPageScreen
import com.second.connect.ui.mypage.NAVIGATION_INQUIRY
import com.second.connect.ui.wallet.WalletScreen
import com.second.connect.ui.share.ShareScreen
import com.second.connect.ui.theme.White

sealed class BottomNavItem(
    val screenRoute: String,
    val unselectIcon: Int,
    val selectIcon: Int
) {
    object Share : BottomNavItem(SHARE, R.drawable.share_unselect, R.drawable.share_select)
    object Wallet: BottomNavItem(WALLET, R.drawable.wallet_unselect, R.drawable.wallet_select)
    object MyPage: BottomNavItem(MY_PAGE, R.drawable.mypage_unselect, R.drawable.mypage_select)
}

const val MY_CARD = "MY_CARD"
const val SHARE = "SHARE"
const val WALLET = "WALLET"
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
        composable(BottomNavItem.Wallet.screenRoute) {
            WalletScreen()
        }
        composable(BottomNavItem.MyPage.screenRoute) {
            MyPageScreen(
                onInquiryClick = {
                    navController.navigate(NAVIGATION_INQUIRY)
                }
            )
        }

        composable(NAVIGATION_INQUIRY) {
            InquiryScreen(
                onButtonClick = {
                    navController.navigate(BottomNavItem.MyPage.screenRoute)
                }
            )
        }
    }
}

@Composable
fun ConnectBottomNavigation(
    navController: NavController
) {
    val navItems = listOf<BottomNavItem>(
        BottomNavItem.Share,
        BottomNavItem.Wallet,
        BottomNavItem.MyPage
    )

    androidx.compose.material3.NavigationBar(
        containerColor = White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { navItem ->
            NavigationBarItem(
                icon = {
                    Image(
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
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}