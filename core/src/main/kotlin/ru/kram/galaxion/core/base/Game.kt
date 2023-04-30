package ru.kram.galaxion.core.base

import android.content.Context
import android.graphics.Canvas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.kram.galaxion.core.characteristics.position.toRect
import ru.kram.galaxion.core.di.DaggerGameComponent
import ru.kram.galaxion.core.di.GameComponent
import ru.kram.galaxion.core.enemies.Enemy
import ru.kram.galaxion.core.enemies.EnemyFactory
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import javax.inject.Inject

class Game(
    private val startSettings: StartSettings
) {
    @Inject
    internal lateinit var enemyFactory: EnemyFactory

	@Inject
	internal lateinit var screenSizeProvider: ScreenSizeProvider

	private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val gameComponent: GameComponent = DaggerGameComponent.factory().create(startSettings)
	private val gameThread = GameThread(this)
	private val timeEnemyMap: MutableMap<Enemy, LastUpdateTime> = hashMapOf()

	private var isPaused = false

    init {
        gameComponent.inject(this)
	}

	fun start() {
		gameThread.start()
	}

    fun stop(): Unit = TODO()

	fun pause() {
		isPaused = true
		gameThread.pause()
	}

	fun resume() {
		isPaused = false
		gameThread.resume_()
	}

	internal fun updateAllPositions() {
		timeEnemyMap.forEach { (enemy, time) ->
			val currentTime = System.currentTimeMillis()
			timeEnemyMap[enemy] = LastUpdateTime(currentTime)
			enemy.updatePosition(currentTime - time.value)
		}
	}

	fun tryCreateEnemy() {
		val newEnemy = enemyFactory.createRandomColorAlien()
		timeEnemyMap[newEnemy] = LastUpdateTime(System.currentTimeMillis())
	}

	fun drawAll(context: Context, canvas: Canvas) {
		timeEnemyMap.keys.forEach { enemy ->
			val image = enemy.getImage(context)
			image?.bounds = enemy.position.toRect(screenSizeProvider)
			image?.draw(canvas)
		}
	}
}