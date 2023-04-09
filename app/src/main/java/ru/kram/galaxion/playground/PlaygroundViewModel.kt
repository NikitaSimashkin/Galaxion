package ru.kram.galaxion.playground

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ru.kram.galaxion.playground.shoot.AngleUtils
import ru.kram.galaxion.playground.shoot.Sector

class PlaygroundViewModel: ViewModel() {

    val colorMap = linkedMapOf(
        Sector.RED to Color.Red,
        Sector.YELLOW to Color.Yellow,
        Sector.BLUE to Color.Blue,
        Sector.GREEN to Color.Green,
    )

    val sectorsCount get() = colorMap.size

    fun shoot(
        touchX: Float,
        touchY: Float,
        canvasSize: Float
    ): Sector {
        val numberSector = AngleUtils.getSectorNumber(
            touchX, touchY, canvasSize / 2, canvasSize / 2, sectorsCount, START_ANGLE
        )
        val touchedSector = colorMap.keys.elementAt(numberSector)
        shoot(touchedSector)

        return touchedSector
    }

    private fun shoot(sector: Sector) {

    }

    companion object {

        const val START_ANGLE = 180f
        const val DEFAULT_ALPHA = 0.2f
        const val TOUCH_ALPHA = 1f
    }
}