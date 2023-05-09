package ru.kram.galaxion.playground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.kram.galaxion.R
import ru.kram.galaxion.playground.shoot.CircleShootButton
import ru.kram.galaxion.ui.theme.dimens
import ru.kram.galaxion.ui.utils.*
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.app.LocalPlaygroundViewModelFactory
import ru.kram.galaxion.playground.game.GameView

private const val TAG = "PlaygroundUi"

@Composable
fun PlaygroundUi(viewModel: PlaygroundViewModel = viewModel(factory = LocalPlaygroundViewModelFactory.current)) {

	FullscreenBackground(resId = R.drawable.b)

	Row(modifier = Modifier.fillMaxSize()) {
		Box(modifier = Modifier.weight(1f)) {
			Image(
				painter = painterResource(R.drawable.base_default),
				contentDescription = "base",
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.FillBounds
			)
			SpaceshipButtonsView(modifier = Modifier.padding(10.dp), viewModel)
		}
		Box(modifier = Modifier.weight(9f), contentAlignment = Alignment.Center) {
			GameView(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
			CircleShootButton(
				canvasModifier = Modifier.size(countShootButtonSize()),
				boxModifier = Modifier
					.align(Alignment.BottomEnd)
					.padding(MaterialTheme.dimens.shootButtonPadding),
				viewModel = viewModel
			)
		}
	}
}

@Composable
private fun countShootButtonSize(): Dp {
	return (0.5 * getScreenHeightDp().value).dp
}

@ScreenPreview
@Composable
fun PlaygroundUiPreview() {
	PlaygroundUi()
}