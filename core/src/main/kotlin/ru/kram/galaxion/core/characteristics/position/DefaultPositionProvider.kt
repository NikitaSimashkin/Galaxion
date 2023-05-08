package ru.kram.galaxion.core.characteristics.position

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.characteristics.size.StartSizeProvider
import ru.kram.galaxion.core.screen.Cell
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.characteristics.size.Size
import kotlin.math.ceil
import kotlin.random.Random

internal class DefaultPositionProvider(
    private val startSizeProvider: StartSizeProvider
) : StartPositionProvider {

    override fun getStartPosition(gameObject: GameObject): Position {
        return when (gameObject) {
            GameObject.Alien -> getAlienStartPosition()
			GameObject.Spaceship -> getSpaceshipStartPosition()
        }
    }

    private fun getAlienStartPosition(): Position {
        val size = startSizeProvider.getSize(GameObject.Alien)
        return getDefaultEndPosition(size)
    }

	private fun getSpaceshipStartPosition(): Position {
		val size = startSizeProvider.getSize(GameObject.Spaceship)
		val topLeftX = leftOffset
		val bottomRightX = topLeftX + size.width

		val topLeftY = verticalOffset
		val bottomRightY = topLeftY + size.height
		return Position(
			topLeftX,
			topLeftY,
			bottomRightX,
			bottomRightY
		)
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
		val leftOffset = Cell.Width(5.0)
    }
}