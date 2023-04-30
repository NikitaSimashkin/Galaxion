package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.screen.Cell


/**
 * Speed per second
 */
data class Speed(
    val speedX: Cell.Width,
    val speedY: Cell.Height
)
