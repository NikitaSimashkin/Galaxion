package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.base.Damagable

internal interface StartDamageProvider {

	fun getDamage(gameObject: Damagable): Damage
}