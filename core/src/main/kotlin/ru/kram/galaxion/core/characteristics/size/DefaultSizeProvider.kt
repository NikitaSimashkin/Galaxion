package ru.kram.galaxion.core.characteristics.size

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.screen.Cell

class DefaultSizeProvider: StartSizeProvider {

    override fun getSize(gameObject: GameObject): Size {
        return when (gameObject) {
            GameObject.Alien -> getAlienSize()
			GameObject.Spaceship -> getSpaceshipSize()
        }
    }

    private fun getAlienSize(): Size {
        val width = alienWidth
        val height = alienHeight
        return Size(width, height)
    }

	private fun getSpaceshipSize(): Size {
		val width = spaceshipWidth
		val height = spaceshipHeight
		return Size(width, height)
	}

    companion object {
        private val alienWidth = Cell.Width(100.0)
        private val alienHeight = Cell.Height(140.0)

		private val spaceshipWidth = Cell.Width(100.0)
		private val spaceshipHeight = Cell.Height(100.0)
    }
}