package ru.kram.galaxion.core.characteristics.damage

import ru.kram.galaxion.core.enemies.Alien
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.utils.STUB

internal class DefaultDamageProvider: DamageProvider {

    override fun <T : Class<out Enemy>> getDamage(clazz: T): Damage {
        when (clazz) {
            Alien::class.java -> return getAlienDamage()
        }

        return STUB
    }

    private fun getAlienDamage(): Damage {
        return alienDamage
    }

    companion object {
        private val alienDamage = Damage(100.0)
    }
}