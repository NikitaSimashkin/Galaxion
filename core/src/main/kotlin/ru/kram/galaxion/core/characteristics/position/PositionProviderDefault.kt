package ru.kram.galaxion.core.characteristics.position

import ru.kram.galaxion.core.characteristics.size.PlaygroundObjectSizeProvider
import ru.kram.galaxion.core.bridge.Cell
import ru.kram.galaxion.core.bridge.ScreenSizeBridge
import ru.kram.galaxion.core.bridge.toPx
import ru.kram.galaxion.core.characteristics.size.Size
import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB
import kotlin.math.ceil
import kotlin.random.Random

internal class PositionProviderDefault(
    private val playgroundObjectSizeProvider: PlaygroundObjectSizeProvider,
    private val screenSizeBridge: ScreenSizeBridge
) : PositionProvider {

    override fun <T : Class<out Enemy>> getStartPosition(clazz: T): Position {
        when (clazz) {
            Alien::class.java -> return getAlienStartPosition()
        }

        return STUB
    }

    private fun getAlienStartPosition(): Position {
        val size = playgroundObjectSizeProvider.getSize(Alien::class.java)
        return getDefaultEndPosition(size)
    }

    private fun getDefaultEndPosition(size: Size): Position {
        val topLeftX = ScreenSizeBridge.fieldWidth + rightOffset
        val bottomRightX = topLeftX + size.width

        val topLeftY = Cell.Height(
            getRandomValue(
                verticalOffset.value,
                (ScreenSizeBridge.fieldHeight - verticalOffset - size.height).value
            )
        )
        val bottomRightY = topLeftY + size.height

        return Position(
            topLeftX.toPx(screenSizeBridge),
            topLeftY.toPx(screenSizeBridge),
            bottomRightX.toPx(screenSizeBridge),
            bottomRightY.toPx(screenSizeBridge)
        )
    }

    private fun getRandomValue(start: Double, end: Double): Double {
        return Random.nextInt(ceil(start).toInt(), end.toInt()).toDouble()
    }

    companion object {
        val verticalOffset = Cell.Height(10.0)
        val rightOffset = Cell.Width(1.0)
    }
}