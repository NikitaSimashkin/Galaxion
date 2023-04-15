package ru.kram.galaxion.core.characteristics.size

import ru.kram.galaxion.core.enemies.Enemy

interface PlaygroundObjectSizeProvider {

    fun <T: Class<out Enemy>> getSize(clazz: T): Size
}