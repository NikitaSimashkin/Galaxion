package ru.kram.galaxion.core.base.size

import ru.kram.galaxion.core.characteristics.Size
import ru.kram.galaxion.core.enemies.Enemy

interface PlaygroundObjectSizeProvider {

    fun <T: Class<out Enemy>> getSize(clazz: T): Size
}