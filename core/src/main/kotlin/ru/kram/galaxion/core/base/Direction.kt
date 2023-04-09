package ru.kram.galaxion.core.base

/**
 * Angle must be in []
 */
@JvmInline
value class Direction(
    val angle: Float
) {

    companion object {

        fun countNewPosition(direction: Direction, position: Position, speed: Speed): Position {
            TODO()
        }
    }
}
