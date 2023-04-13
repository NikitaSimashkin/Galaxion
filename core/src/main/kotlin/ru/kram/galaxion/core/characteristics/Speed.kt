package ru.kram.galaxion.core.characteristics

import ru.kram.galaxion.core.bridge.Cell


/**
 * Speed per second
 */
data class Speed(
    val speedX: Cell.Width,
    val speedY: Cell.Height
)
