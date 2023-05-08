package ru.kram.galaxion.playground

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.StartSettings
import ru.kram.galaxion.core.fps.FpsCounter
import ru.kram.galaxion.playground.shoot.AngleUtils
import ru.kram.galaxion.playground.shoot.Sector

class PlaygroundViewModel(
	private val widthPx: Double,
	private val heightPx: Double,
	private val navController: NavController
): ViewModel() {

	val fpsCounter = FpsCounter(60)

	val game = Game(
		startSettings = StartSettings.Builder(widthPx, heightPx)
			.setEnemies(mapOf(GameObject.Alien to 3))
			.setFpsCounter(fpsCounter)
			.build()
	)

    val colorMap = linkedMapOf(
        Sector.RED to Color.Red,
        Sector.YELLOW to Color.Yellow,
        Sector.BLUE to Color.Blue,
        Sector.GREEN to Color.Green,
    )

    val sectorsCount get() = colorMap.size

	fun upSpaceship() {
		game.upSpaceship()
	}

	fun downSpaceship() {
		game.downSpaceship()
	}

	fun staySpaceship() {
		game.staySpaceship()
	}

	fun startGame(context: Context) {
		game.load(context) {
			game.start()
		}
	}

	fun stopGame() {
		game.stop()
	}

    fun shoot(
        touchX: Float,
        touchY: Float,
        canvasSize: Float
    ): Sector {
        val numberSector = AngleUtils.getSectorNumber(
            touchX, touchY, canvasSize / 2, canvasSize / 2, sectorsCount, START_ANGLE
        )
        val touchedSector = colorMap.keys.elementAt(numberSector)
        shoot(touchedSector)

        return touchedSector
    }

    private fun shoot(sector: Sector) {

    }

    companion object {

        const val START_ANGLE = 180f
        const val DEFAULT_ALPHA = 0.2f
        const val TOUCH_ALPHA = 1f
    }
}