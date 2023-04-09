package ru.kram.galaxion.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kram.galaxion.levels.LevelsUi
import ru.kram.galaxion.menu.MainMenuUi
import ru.kram.galaxion.playground.shoot.CircleShootButton

val LocalNavController = compositionLocalOf<NavController> { error("No NavController") }

@Composable
fun CreateNavigationGraph() {

    val navController = rememberNavController()

    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(navController = navController, startDestination = Screen.MainMenuScreen.route){
            composable(Screen.MainMenuScreen.route) {
                MainMenuUi()
            }

            composable(Screen.LevelsScreen.route) {
                LevelsUi()
            }

            composable(Screen.PlaygroundScreen.route) {
                CircleShootButton()
            }
        }
    }
}
