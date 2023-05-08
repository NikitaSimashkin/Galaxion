package ru.kram.galaxion.ui.utils.touch

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntSize

internal fun Modifier.pointerInput(
	up: (x: Float, y: Float) -> Unit,
	down: (x: Float, y: Float) -> Unit,
	size: IntSize,
	callUpWhenOutOfBounds: Boolean = false
): Modifier = this.pointerInput(Unit) {
	awaitEachGesture {
		do {
			val nextEvent = awaitPointerEvent(PointerEventPass.Main).changes[0]
			val inBounds =
				nextEvent.position.x in 0f..size.width.toFloat() && nextEvent.position.y in 0f..size.height.toFloat()

			if (inBounds == false && callUpWhenOutOfBounds) {
				up(nextEvent.position.x, nextEvent.position.y)
				break
			} else if (nextEvent.pressed) {
				down(nextEvent.position.x, nextEvent.position.y)
			} else {
				up(nextEvent.position.x, nextEvent.position.y)
			}
		} while (nextEvent.pressed)
	}
}
