package ru.kram.galaxion.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kram.galaxion.levels.LevelsUi
import ru.kram.galaxion.levels.LevelsViewModelFactory
import ru.kram.galaxion.menu.MainMenuUi
import ru.kram.galaxion.menu.MainMenuViewModelFactory
import ru.kram.galaxion.playground.PlaygroundUi
import ru.kram.galaxion.playground.PlaygroundViewModel
import ru.kram.galaxion.playground.PlaygroundViewModelFactory
import ru.kram.galaxion.ui.utils.getScreenHeightPx
import ru.kram.galaxion.ui.utils.getScreenWidthPx

@Composable
fun CreateNavigationGraph() {

	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = Screen.MainMenuScreen.route) {
		composable(Screen.MainMenuScreen.route) {
			CompositionLocalProvider(
				LocalMainMenuViewModelFactory provides MainMenuViewModelFactory(navController)
			) {
				MainMenuUi()
			}
		}

		composable(Screen.LevelsScreen.route) {
			CompositionLocalProvider(
				LocalLevelsViewModelFactory provides LevelsViewModelFactory(navController)
			) {
				LevelsUi()
			}
		}


		composable(Screen.PlaygroundScreen.route) {
			CompositionLocalProvider(
				LocalPlaygroundViewModelFactory provides PlaygroundViewModelFactory(navController)
			) {
				PlaygroundUi()
			}
		}
	}
}
