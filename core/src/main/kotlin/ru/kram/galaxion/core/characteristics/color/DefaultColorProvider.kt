package ru.kram.galaxion.core.characteristics.color

internal class DefaultColorProvider(private val colors: List<Color>): ColorProvider {

    override fun getRandomColor(): Color {
        return colors.random()
    }

    override fun getColorByIndex(index: Int): Color? {
        return colors.getOrNull(index)
    }
}