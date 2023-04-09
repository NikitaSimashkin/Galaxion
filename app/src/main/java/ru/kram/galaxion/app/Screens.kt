package ru.kram.galaxion.app

sealed class Screen(val route: String){
    object MainMenuScreen: Screen("mainMenu")
    object LevelsScreen: Screen("levels")
    object PlaygroundScreen: Screen("playground")
    object ShopScreen: Screen("shop")
    object SettingsScreen: Screen("settings")
}
