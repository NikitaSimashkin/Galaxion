package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.base.GameObject

interface StartHpProvider {

    fun getHp(gameObject: GameObject): Hp
}