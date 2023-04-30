package ru.kram.galaxion.core.screen

import ru.kram.galaxion.core.utils.Px

internal class ScreenSizeProvider(
    val widthPx: Double,
    val heightPx: Double
) {

    companion object {
        val fieldWidth = Cell.Width(1000.0)
        val fieldHeight = Cell.Height(500.0)
    }
}

internal fun Cell.Height.toPx(screenSizeProvider: ScreenSizeProvider): Px {
    return Px(value * (screenSizeProvider.heightPx / ScreenSizeProvider.fieldHeight.value))
}

internal fun Cell.Width.toPx(screenSizeProvider: ScreenSizeProvider): Px {
    return Px(value * (screenSizeProvider.widthPx / ScreenSizeProvider.fieldWidth.value))
}