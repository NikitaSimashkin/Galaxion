package ru.kram.galaxion.core.base

import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.core.fps.FpsCounter
import ru.kram.galaxion.data.skins.SkinInfo

data class StartSettings internal constructor(
    val widthPx: Double,
    val heightPx: Double,
    val colors: List<Color>,
    val skins: List<SkinInfo>,
	val enemyNumber: Map<GameObject, Int>,
	val fpsCounter: FpsCounter
) {

    class Builder(
        private val widthPx: Double,
        private val heightPx: Double,
    ) {
        private var colors: List<Color> = listOf(Color(0xFF0000), Color(0x00FF00), Color(0x0000FF))
        private var skins: List<SkinInfo> = listOf()
		private var enemyNumber: Map<GameObject, Int> = mapOf()
		private var fpsCounter = FpsCounter(60)

        fun setColors(colors: List<Color>) = this.apply { this.colors = colors }

        fun setSkins(skins: List<SkinInfo>) = this.apply { this.skins = skins }

		fun setFpsCounter(fpsCounter: FpsCounter) = this.apply { this.fpsCounter = fpsCounter }

		fun setEnemies(enemyNumber: Map<GameObject, Int>) = this.apply { this.enemyNumber = enemyNumber }

        fun build() = StartSettings(
            widthPx = widthPx,
            heightPx = heightPx,
            colors = colors,
            skins = skins,
			enemyNumber = enemyNumber,
			fpsCounter = fpsCounter
        )
    }
}
