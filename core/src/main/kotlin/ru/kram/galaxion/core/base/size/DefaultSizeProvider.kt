package ru.kram.galaxion.core.base.size

import ru.kram.galaxion.core.bridge.Cell
import ru.kram.galaxion.core.bridge.ScreenSizeBridge
import ru.kram.galaxion.core.characteristics.Size
import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB

class DefaultSizeProvider: PlaygroundObjectSizeProvider {

    override fun <T : Class<out Enemy>> getSize(clazz: T): Size {
        when (clazz) {
            Alien::class.java -> return getAlienSize()
        }

        return STUB
    }

    private fun getAlienSize(): Size {
        val width = alienWidth
        val height = alienHeight
        return Size(width, height)
    }

    companion object {
        private val alienWidth = Cell.Width(100.0)
        private val alienHeight = Cell.Height(80.0)
    }
}