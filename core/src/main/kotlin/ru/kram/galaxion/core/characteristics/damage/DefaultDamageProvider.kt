package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.base.Damagable
import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.utils.STUB

internal class DefaultDamageProvider: StartDamageProvider {

    override fun getDamage(gameObject: Damagable): Damage {
        return when (gameObject) {
            GameObject.Alien -> getAlienDamage()
        }
    }

    private fun getAlienDamage(): Damage {
        return alienDamage
    }

    companion object {
        private val alienDamage = Damage(100.0)
    }
}