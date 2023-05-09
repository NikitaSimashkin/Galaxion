package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.base.Hpable

internal interface StartHpProvider {

	fun getHp(gameObject: Hpable): Hp
}