package ru.kram.galaxion.app

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import ru.kram.galaxion.levels.LevelsViewModelFactory
import ru.kram.galaxion.menu.MainMenuViewModelFactory
import ru.kram.galaxion.playground.PlaygroundViewModel
import ru.kram.galaxion.playground.PlaygroundViewModelFactory

val LocalMainMenuViewModelFactory: ProvidableCompositionLocal<MainMenuViewModelFactory> =
    staticCompositionLocalOf { error("Provide view model factory!") }

val LocalLevelsViewModelFactory: ProvidableCompositionLocal<LevelsViewModelFactory> =
	staticCompositionLocalOf { error("Provide view model factory!") }

val LocalPlaygroundViewModelFactory: ProvidableCompositionLocal<PlaygroundViewModelFactory> =
	staticCompositionLocalOf { error("Provide view model factory!") }