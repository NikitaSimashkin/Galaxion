package ru.kram.galaxion.core.enemies

import ru.kram.galaxion.core.characteristics.color.ColorProvider
import ru.kram.galaxion.core.characteristics.damage.DamageProvider
import ru.kram.galaxion.core.characteristics.direction.DirectionProvider
import ru.kram.galaxion.core.characteristics.hp.HpProvider
import ru.kram.galaxion.core.characteristics.position.PositionProvider
import ru.kram.galaxion.core.characteristics.speed.SpeedProvider

internal class DefaultEnemyFactory(
    private val positionProvider: PositionProvider,
    private val damageProvider: DamageProvider,
    private val speedProvider: SpeedProvider,
    private val hpProvider: HpProvider,
    private val directionProvider: DirectionProvider,
    private val colorProvider: ColorProvider
): EnemyFactory {

    override fun createRandomColorAlien(): Alien {
        return Alien(
            position = positionProvider.getStartPosition(Alien::class.java),
            damage = damageProvider.getDamage(Alien::class.java),
            hp = hpProvider.getHp(Alien::class.java),
            speed = speedProvider.getSpeed(Alien::class.java),
            direction = directionProvider.getDirection(Alien::class.java),
            color = colorProvider.getRandomColor(),
        )
    }
}