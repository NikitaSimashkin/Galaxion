package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.base.GameObject

interface StartDamageProvider {

    fun getDamage(gameObject: GameObject): Damage
}