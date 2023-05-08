package ru.kram.galaxion.playground.shoot

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kram.galaxion.playground.PlaygroundViewModel
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.DEFAULT_ALPHA
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.START_ANGLE
import ru.kram.galaxion.playground.PlaygroundViewModel.Companion.TOUCH_ALPHA
import ru.kram.galaxion.ui.utils.touch.pointerInput

@Composable
fun CircleShootButton(
	boxModifier: Modifier = Modifier,
	canvasModifier: Modifier = Modifier,
	viewModel: PlaygroundViewModel = viewModel()
) {
	Box(modifier = boxModifier) {

		var touchX by remember { mutableStateOf(0f) }
		var touchY by remember { mutableStateOf(0f) }
		var isPressed by remember { mutableStateOf(false) }
		var size by remember { mutableStateOf(IntSize.Zero) }

		Canvas(modifier = canvasModifier
			.aspectRatio(1f)
			.background(Color.Transparent)
			.onGloballyPositioned {
				size = it.size
			}
			.pointerInput(
				up = { _, _ ->
					isPressed = false
				},
				down = { x, y ->
					touchX = x
					touchY = y
					isPressed = true
				},
				size = size,
				callUpWhenOutOfBounds = false
			)
		) {
			var lastDrawAngle = START_ANGLE
			val arcLength = 360f / viewModel.sectorsCount
			val touchedSector =
				if (isPressed) viewModel.shoot(touchX, touchY, this.size.height) else null

			for (i in viewModel.colorMap) {
				val alpha = if (touchedSector != i.key) DEFAULT_ALPHA else TOUCH_ALPHA
				drawSector(alpha, lastDrawAngle, arcLength, i.value)
				lastDrawAngle += arcLength
			}

		}
	}
}

private fun DrawScope.drawSector(
	alpha: Float,
	startAngle: Float,
	arcLength: Float,
	color: Color
) {
	drawArc(
		color = color,
		startAngle = startAngle,
		sweepAngle = arcLength,
		useCenter = true,
		alpha = alpha,
	)
}

@Composable
@Preview(showBackground = true)
fun CircleShootButtonPreview(
) {
	CircleShootButton()
}
