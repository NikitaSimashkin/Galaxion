package ru.kram.galaxion.playground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.R
import ru.kram.galaxion.app.LocalPlaygroundViewModelFactory
import ru.kram.galaxion.ui.theme.playgroundDownButton
import ru.kram.galaxion.ui.theme.playgroundUpButton
import ru.kram.galaxion.ui.utils.ComponentPreview
import ru.kram.galaxion.ui.utils.touch.pointerInput

@Composable
fun SpaceshipButtonsView(modifier: Modifier = Modifier, viewModel: PlaygroundViewModel = viewModel(factory = LocalPlaygroundViewModelFactory.current)) {
	Column(modifier = modifier) {
		Spacer(modifier = Modifier.weight(1f))
		ControlButtons(modifier = Modifier.weight(2f), viewModel = viewModel)
		Spacer(modifier = Modifier.weight(1f))
	}
}

@Composable
fun ControlButtons(modifier: Modifier = Modifier, viewModel: PlaygroundViewModel) {

	val maxAlpha = 1f
	val minAlpha = 0.2f

	var upButtonAlpha by remember { mutableStateOf(minAlpha) }
	var downButtonAlpha by remember { mutableStateOf(minAlpha) }
	var size by remember { mutableStateOf(IntSize.Zero) }

	Column(
		modifier = modifier
			.onGloballyPositioned {
				size = it.size
			}
			.pointerInput(
				down = { _, y ->
					if (y < size.height / 2) {
						viewModel.downSpaceship()
						upButtonAlpha = maxAlpha
						downButtonAlpha = minAlpha
					} else {
						viewModel.upSpaceship()
						upButtonAlpha = minAlpha
						downButtonAlpha = maxAlpha
					}
				},
				up = { _, _ ->
					viewModel.staySpaceship()
					downButtonAlpha = minAlpha
					upButtonAlpha = minAlpha
				},
				size = size,
				callUpWhenOutOfBounds = false
			)
	) {

		Image(
			painter = painterResource(id = R.drawable.up_button),
			contentDescription = "up button",
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth(),
			contentScale = ContentScale.FillBounds,
			colorFilter = ColorFilter.tint(MaterialTheme.colors.playgroundUpButton),
			alpha = upButtonAlpha
		)
		Image(
			painter = painterResource(id = R.drawable.down_button),
			contentDescription = "down button",
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth(),
			contentScale = ContentScale.FillBounds,
			colorFilter = ColorFilter.tint(MaterialTheme.colors.playgroundDownButton),
			alpha = downButtonAlpha
		)
	}
}

@ComponentPreview
@Composable
fun SpaceshipButtonsPreview() {
	SpaceshipButtonsView()
}