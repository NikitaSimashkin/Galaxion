package ru.kram.galaxion.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LocalDim = staticCompositionLocalOf { Dimensions() }

data class Dimensions(

    // Padding

    val mainMenuButtonMargin: Dp = 4.dp,
    val mainMenuCenterRowMargin: Dp = 10.dp,
    val mainMenuColumnmMargin: Dp = 8.dp,
    val mainMenuButtonBorder: Dp = 4.dp,


    val levelsGridMargin: Dp = 8.dp,
    val levelsButtonMargin: Dp = 8.dp,

    // FontSize

    val mainMenuButtonFontSize: TextUnit = 20.sp,
    val levelFontSize: TextUnit = 25.sp,

    // ViewSize

    val shootButton: Dp = 200.dp

)
