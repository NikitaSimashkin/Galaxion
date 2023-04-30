package ru.kram.galaxion.core.characteristics.position

import android.graphics.Rect
import ru.kram.galaxion.core.screen.Cell
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.screen.toPx

data class Position(
    val topLeftX: Cell.Width,
    val topLeftY: Cell.Height,
    val bottomRightX: Cell.Width,
    val bottomRightY: Cell.Height
)

internal fun Position.toRect(screenSizeProvider: ScreenSizeProvider): Rect {
	return Rect(
		topLeftX.toPx(screenSizeProvider).value.toInt(),
		topLeftY.toPx(screenSizeProvider).value.toInt(),
		bottomRightX.toPx(screenSizeProvider).value.toInt(),
		bottomRightY.toPx(screenSizeProvider).value.toInt()
	)
}