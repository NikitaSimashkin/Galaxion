package ru.kram.galaxion.core.characteristics.size

import ru.kram.galaxion.core.base.GameObject

interface StartSizeProvider {

    fun getSize(gameObject: GameObject): Size
}