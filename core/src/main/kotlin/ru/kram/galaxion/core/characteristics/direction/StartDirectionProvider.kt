package ru.kram.galaxion.core.characteristics.direction

import ru.kram.galaxion.core.base.GameObject

interface StartDirectionProvider {

    fun getDirection(gameObject: GameObject): Direction
}