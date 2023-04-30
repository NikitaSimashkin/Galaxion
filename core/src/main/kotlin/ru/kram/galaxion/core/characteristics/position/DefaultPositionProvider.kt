package ru.kram.galaxion.core.characteristics.position

import ru.kram.galaxion.core.characteristics.size.PlaygroundObjectSizeProvider
import ru.kram.galaxion.core.screen.Cell
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.characteristics.size.Size
import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB
import kotlin.math.ceil
import kotlin.random.Random

internal class DefaultPositionProvider(
    private val playgroundObjectSizeProvider: PlaygroundObjectSizeProvider,
    private val screenSizeProvider: ScreenSizeProvider
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
        val topLeftX = ScreenSizeProvider.fieldWidth + rightOffset
        val bottomRightX = topLeftX + size.width

        val topLeftY = Cell.Height(
            getRandomValue(
                verticalOffset.value,
                (ScreenSizeProvider.fieldHeight - verticalOffset - size.height).value
            )
        )
        val bottomRightY = topLeftY + size.height

        return Position(
            topLeftX,
            topLeftY,
            bottomRightX,
            bottomRightY
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