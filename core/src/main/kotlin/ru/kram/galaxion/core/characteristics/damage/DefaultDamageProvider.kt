package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.utils.STUB

internal class DefaultDamageProvider: StartDamageProvider {

    override fun getDamage(gameObject: GameObject): Damage {
        return when (gameObject) {
            GameObject.Alien -> getAlienDamage()
			else -> STUB
        }
    }

    private fun getAlienDamage(): Damage {
        return alienDamage
    }

    companion object {
        private val alienDamage = Damage(100.0)
    }
}