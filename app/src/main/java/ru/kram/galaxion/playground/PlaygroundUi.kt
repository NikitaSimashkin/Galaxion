package ru.kram.galaxion.playground

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kram.galaxion.R
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.core.base.StartSettings
import ru.kram.galaxion.ui.utils.*

@Composable
fun PlaygroundUi() {

	FullscreenBackground(resId = R.drawable.b)

	val game = Game(
		startSettings =
		StartSettings.Builder(getScreenWidthPx().toDouble(), getScreenHeightPx().toDouble())
			.build()
	)

	game.tryCreateEnemy()

	GameView(modifier = Modifier.fillMaxSize(), game = game)

	game.start()
}

@ScreenPreview
@Composable
fun PlaygroundUiPreview() {
	PlaygroundUi()
}