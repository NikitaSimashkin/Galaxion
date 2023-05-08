package ru.kram.galaxion.core.characteristics.position

import ru.kram.galaxion.core.base.GameObject

internal interface StartPositionProvider {

    fun getStartPosition(gameObject: GameObject): Position
}