package ru.kram.galaxion.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LocalDim = staticCompositionLocalOf { Dimensions() }

data class Dimensions(

    // Padding

    val mainMenuCenterRowMargin: Dp = 10.dp,
    val mainMenuColumnmMargin: Dp = 8.dp,
    val mainMenuButtonBorder: Dp = 4.dp,
    val mainMenuHorizontalMargin: Dp = 12.dp,
    val mainMenuBottomMargin: Dp = 16.dp,
    val mainMenuBottomButtonsMargin: Dp = 16.dp,

    val levelsBetweenButtonMargin: Dp = 20.dp,
    val levelsHorizontalMargin: Dp = 20.dp,
    val levelButtonBorder: Dp = 4.dp,

    // FontSize

    val mainMenuButtonFontSize: TextUnit = 35.sp,
    val levelFontSize: TextUnit = 25.sp,

    // ViewSize

    val shootButton: Dp = 200.dp

)
