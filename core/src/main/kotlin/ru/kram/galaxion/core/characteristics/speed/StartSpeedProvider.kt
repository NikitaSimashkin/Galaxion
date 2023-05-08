package ru.kram.galaxion.core.characteristics.speed

import ru.kram.galaxion.core.base.GameObject

interface StartSpeedProvider {

    fun getSpeed(gameObject: GameObject): Speed
}