package ru.kram.galaxion.playground

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.StartSettings
import ru.kram.galaxion.core.fps.FpsCounter
import ru.kram.galaxion.playground.shoot.AngleUtils
import ru.kram.galaxion.playground.shoot.Sector
import ru.kram.galaxion.ui.utils.LogG

class PlaygroundViewModel(
	private val navController: NavController
): ViewModel() {

	val fpsCounter = FpsCounter(60)

    val colorMap = linkedMapOf(
        Sector.RED to Color.Red,
        Sector.YELLOW to Color.Yellow,
        Sector.BLUE to Color.Blue,
        Sector.GREEN to Color.Green,
    )

	var game: Game? = null

    val sectorsCount get() = colorMap.size

	private val spaceshipController get() = game?.getSpaceshipController()

	fun upSpaceship() {
		spaceshipController?.up()
	}

	fun downSpaceship() {
		spaceshipController?.down()
	}

	fun staySpaceship() {
		spaceshipController?.stay()
	}

	fun startGame(context: Context, widthPx: Double, heightPx: Double) {
		LogG.d("PlaygroundViewModel", "startGame()")
		game = Game(
			startSettings = StartSettings.Builder(widthPx, heightPx)
				.setEnemies(mapOf(GameObject.Alien to 3))
				.setColors(colorMap.values.map {
					ru.kram.galaxion.core.characteristics.color.Color(
						it.value.toInt()
					)
				})
				.setFpsCounter(fpsCounter)
				.build()
		)
		game?.load(context) {
			game?.start()
		}
	}

	fun stopGame() {
		LogG.d("PlaygroundViewModel", "stopGame()")
		game?.stop()
		game = null
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