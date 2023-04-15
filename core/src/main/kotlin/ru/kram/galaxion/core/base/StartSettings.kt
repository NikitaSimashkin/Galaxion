package ru.kram.galaxion.core.base

import ru.kram.galaxion.core.characteristics.color.Color
import ru.kram.galaxion.data.skins.SkinInfo

data class StartSettings private constructor(
    val widthPx: Double,
    val heightPx: Double,
    val colors: List<Color>,
    val skins: List<SkinInfo>
) {

    class Builder(
        private val widthPx: Double,
        private val heightPx: Double,
    ) {
        private var colors: List<Color> = listOf(Color(0xFF0000), Color(0x00FF00), Color(0x0000FF))
        private var skins: List<SkinInfo> = listOf()

        fun setColors(colors: List<Color>) = this.apply { this.colors = colors }

        fun setSkins(skins: List<SkinInfo>) = this.apply { this.skins = skins }

        fun build() = StartSettings(
            widthPx = widthPx,
            heightPx = heightPx,
            colors = colors,
            skins = skins
        )
    }
}
