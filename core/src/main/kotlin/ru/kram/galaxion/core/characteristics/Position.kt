package ru.kram.galaxion.core.characteristics

import ru.kram.galaxion.core.utils.Px

internal data class Position(
    val topLeftX: Px,
    val topLeftY: Px,
    val bottomRightX: Px,
    val bottomRightY: Px
)