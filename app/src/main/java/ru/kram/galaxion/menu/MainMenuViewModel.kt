package ru.kram.galaxion.menu

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import ru.kram.galaxion.app.Screen

class MainMenuViewModel(private val navController: NavController): ViewModel() {

    fun openLevels() {
        navController.navigate(Screen.LevelsScreen.route)
    }

    fun openShop() {
        navController.navigate(Screen.ShopScreen.route)
    }

    fun openSettings() {
        navController.navigate(Screen.SettingsScreen.route)
    }
}