package com.blackfox.mypasswordsafe.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.blackfox.mypasswordsafe.android.ui.AboutScreen
import com.blackfox.mypasswordsafe.android.ui.BottomNavItem
import com.blackfox.mypasswordsafe.android.ui.HomeScreen
import com.blackfox.mypasswordsafe.android.ui.SettingsScreen
import com.blackfox.mypasswordsafe.android.ui.VaultScreen

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Settings : Screen("settings_screen")
    object Vault : Screen("vault_screen")
    object About : Screen("about_screen")
}

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen(navController)
        }
        composable(BottomNavItem.Vault.route) {
            VaultScreen()
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
    }
}