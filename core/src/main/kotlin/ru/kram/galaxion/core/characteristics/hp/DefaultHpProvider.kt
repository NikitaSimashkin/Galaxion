package ru.kram.galaxion.core.characteristics.hp

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.Hpable

internal class DefaultHpProvider: StartHpProvider {

	override fun getHp(gameObject: Hpable): Hp {
		return when (gameObject) {
			GameObject.Alien -> getAlienHp()
		}
	}

	private fun getAlienHp(): Hp {
		return alienHp
	}

	companion object {
		private val alienHp = Hp(200.0)
	}
}