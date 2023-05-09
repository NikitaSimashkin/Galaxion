package ru.kram.galaxion.core.base

import kotlinx.coroutines.*
import ru.kram.galaxion.core.fps.FpsCounter
import ru.kram.galaxion.core.utils.Time
import java.lang.Object

internal class GameThread(
	private val game: Game,
	private val fpsCounter: FpsCounter
) {

	private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
	private var mainJob: Job? = null
	private var isStarted: Boolean = false

	fun pause() {
		synchronized(this) {
			(this as Object).wait()
		}
	}

	fun resume() {
		synchronized(this) {
			(this as Object).notify()
		}
	}

	fun start() {
		if (isStarted) return

		coroutineScope.launch {
			mainJob = launch {
				while(isActive){
					game.updateAllPositions()
				}
			}
			delay(Time(START_PAUSE_SECONDS * Time.SECOND).toDuration())
			mainJob?.cancel()

			mainJob = launch {
				while(isActive) {
					game.updateAllPositions()
					game.tryCreateEnemy()
				}
			}
		}

		isStarted = true
	}

	fun interrupt() {
		coroutineScope.cancel()
	}

	companion object {
		private const val START_PAUSE_SECONDS = 2
	}
}