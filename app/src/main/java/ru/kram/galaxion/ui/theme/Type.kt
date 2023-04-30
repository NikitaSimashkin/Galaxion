package ru.kram.galaxion.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

internal val DefaultTypography = Typography(

)

val Typography.levelButton: TextStyle
    @Composable
    get() = TextStyle(
        color = MaterialTheme.colors.levelText,
        fontSize = LocalDim.current.levelFontSize,
    )

val Typography.mainMenuButton: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = MaterialTheme.dimens.mainMenuButtonFontSize,
        color = MaterialTheme.colors.mainMenuButtonText,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )