package ru.kram.galaxion.core.base

import android.content.Context
import android.graphics.Canvas
import android.util.Log
import kotlinx.coroutines.*
import ru.kram.galaxion.core.characteristics.position.toRect
import ru.kram.galaxion.core.controller.GameObjectControllerFactory
import ru.kram.galaxion.core.di.DaggerGameComponent
import ru.kram.galaxion.core.di.GameComponent
import ru.kram.galaxion.core.enemies.GameObjectFactory
import ru.kram.galaxion.core.image.ImageStorage
import ru.kram.galaxion.core.screen.PlaygroundObject
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.spaceship.Spaceship
import ru.kram.galaxion.core.spaceship.SpaceshipController
import ru.kram.galaxion.core.spaceship.SpaceshipControllerImpl
import ru.kram.galaxion.core.utils.Time
import javax.inject.Inject

class Game(
    private val startSettings: StartSettings
) {
    @Inject
    internal lateinit var gameObjectFactory: GameObjectFactory

	@Inject
	internal lateinit var gameObjectControllerFactory: GameObjectControllerFactory

	@Inject
	internal lateinit var screenSizeProvider: ScreenSizeProvider

	@Inject
	internal lateinit var imageStorage: ImageStorage

	@Inject
	internal lateinit var gameThread: GameThread

	private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val gameComponent: GameComponent = DaggerGameComponent.factory().create(this, startSettings)

	private val lastTimeUpdateObjectMap: MutableMap<PlaygroundObject, Time> = hashMapOf()

	var gameState: GameState = GameState.NO_LOADING
		private set
	private var lastGameState: GameState? = null

	private var spaceship: Spaceship? = null

	private var spaceshipController: SpaceshipController? = null

    init {
        gameComponent.inject(this)
	}

	fun load(context: Context, callback: () -> Unit) {
		if (gameState == GameState.NO_LOADING) {
			gameState = GameState.LOADING
			coroutineScope.launch {
				val loadJob = launch {
					imageStorage.loadAll(context)
				}
				loadJob.join()
				gameState = GameState.END_LOADING
				callback()
			}
		}
	}

	fun getSpaceshipController(): SpaceshipController {
		if (spaceship == null) {
			throw java.lang.Exception("You must start game before call getSpaceshipController")
		}
		if (spaceshipController == null) {
			spaceshipController = gameObjectControllerFactory.createSpaceshipController(requireNotNull(spaceship))
		}

		return requireNotNull(spaceshipController)
	}

	fun start() {
		if (gameState != GameState.END_LOADING)
			throw java.lang.Exception("You must load game before start")
		gameState = GameState.ACTIVE

		createSpaceship()
		coroutineScope.launch {
			gameThread.start()
			startSettings.fpsCounter.start()
		}
	}

    fun stop() {
		gameState = GameState.STOPPED
		gameThread.interrupt()
		coroutineScope.cancel()
		startSettings.fpsCounter.stop()
	}

	fun pause() {
		lastGameState = gameState
		gameState = GameState.PAUSE
		gameThread.pause()
	}

	fun resume() {
		gameState = lastGameState ?: GameState.ACTIVE
		gameThread.resume()
	}

	internal fun updateAllPositions() {
		lastTimeUpdateObjectMap.forEach { (obj, time) ->
			val currentTime = Time.getCurrentTime()
			lastTimeUpdateObjectMap[obj] = currentTime
			obj.updatePosition(Time(currentTime.value - time.value))
		}
	}

	@Synchronized
	fun tryCreateEnemy() {
		//if (lastTimeUpdateObjectMap.size == 2) return
		if(flag) return
		val newEnemy = gameObjectFactory.createRandomColorAlien()
		lastTimeUpdateObjectMap[newEnemy] = Time.getCurrentTime()
		flag = true
	}

	var flag = false

	@Synchronized
	fun createSpaceship() {
		gameObjectFactory.createSpaceship().apply {
			spaceship = this
			lastTimeUpdateObjectMap[this] = Time.getCurrentTime()
		}
	}

	@Synchronized
	fun drawAll(canvas: Canvas) {
		lastTimeUpdateObjectMap.keys.forEach { obj ->
			val image = imageStorage.getImage(obj.image ?: return)
			image?.bounds = obj.position.toRect(screenSizeProvider)
			image?.draw(canvas)
		}
	}
}