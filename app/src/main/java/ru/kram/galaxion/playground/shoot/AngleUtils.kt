package ru.kram.galaxion.playground.shoot

import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

internal object AngleUtils {

    fun getSectorNumber(
        touchedX: Float,
        touchedY: Float,
        centerX: Float,
        centerY: Float,
        sectorCount: Int,
        startAngle: Float
    ): Int {
        var angle = calculateAngle(touchedX, touchedY, centerX * 2, centerY, centerX, centerY)
        angle = if (touchedY < centerY) -abs(angle) else abs(angle)

        val sectorSize = 360f / sectorCount
        val offsetAngle = angle + startAngle
        val normalizedAngle = (offsetAngle + 360) % 360
        return (normalizedAngle / sectorSize).toInt()
    }

    /**
    x1 and y1, x2 and y2 are coordinates of side opposite searchable angle
     */
    private fun calculateAngle(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float): Float {
        val side1 = calculateLength(x1, y1, x2, y2)
        val side2 = calculateLength(x2, y2, x3, y3)
        val side3 = calculateLength(x1, y1, x3, y3)

        val cosAngle = -((side1.pow(2) - side2.pow(2) - side3.pow(2)) / (2 * side2 * side3))
        return Math.toDegrees(acos(cosAngle).toDouble()).toFloat()
    }

    private fun calculateLength(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        return sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))
    }
}