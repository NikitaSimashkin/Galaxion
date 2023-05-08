package ru.kram.galaxion.core.fps

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import ru.kram.galaxion.core.utils.Time
import ru.kram.galaxion.core.utils.Time.Companion.SECOND

class FpsCounter(private val fps: Int) {

	private val internalCounter = MutableSharedFlow<Int>()
	val counter: SharedFlow<Int> = internalCounter

	private var count = 0
	private var isStarted: Boolean = false

	private val coroutineScope = CoroutineScope(Dispatchers.IO)

	internal fun start() {
		if (isStarted) return

		coroutineScope.launch {
			val delay = countDelay()
			while(true) {
				delay(delay.toDuration())
				internalCounter.emit((count++) % fps)
			}
		}

		isStarted = true
	}

	internal fun stop() {
		coroutineScope.cancel()
	}

	private fun countDelay(): Time {
		return Time(SECOND / fps)
	}
}