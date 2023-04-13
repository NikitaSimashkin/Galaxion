package ru.kram.galaxion.core.bridge

import ru.kram.galaxion.core.utils.Px

internal class ScreenSizeBridge(
    val widthPx: Double,
    val heightPx: Double
) {

    companion object {
        val fieldWidth = Cell.Width(1000.0)
        val fieldHeight = Cell.Height(500.0)
    }
}

internal fun Cell.Height.toPx(screenSizeBridge: ScreenSizeBridge): Px {
    return Px(value * (screenSizeBridge.heightPx / ScreenSizeBridge.fieldHeight.value))
}

internal fun Cell.Width.toPx(screenSizeBridge: ScreenSizeBridge): Px {
    return Px(value * (screenSizeBridge.widthPx / ScreenSizeBridge.fieldWidth.value))
}