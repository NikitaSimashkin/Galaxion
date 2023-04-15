package ru.kram.galaxion.core.base

import ru.kram.galaxion.core.bridge.ScreenSizeBridge
import ru.kram.galaxion.core.enemies.EnemyFactory
import javax.inject.Inject

class Game(
    private val startSettings: StartSettings
) {

    @Inject
    internal lateinit var screenSizeBridge: ScreenSizeBridge

    @Inject
    internal lateinit var enemyFactory: EnemyFactory
}