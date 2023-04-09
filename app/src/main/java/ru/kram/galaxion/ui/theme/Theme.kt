package ru.kram.galaxion.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

val MaterialTheme.dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDim.current

@Composable
fun GalaxionTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDim provides Dimensions()
    ) {
        MaterialTheme(
            colors = LightColorPalette,
            typography = DefaultTypography,
            shapes = DefaultShapes
        ) {
        }
    }
}