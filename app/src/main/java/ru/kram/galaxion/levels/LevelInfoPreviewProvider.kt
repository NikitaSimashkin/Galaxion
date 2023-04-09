package ru.kram.galaxion.levels

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import ru.kram.galaxion.data.levels.LevelInfo

class LevelInfoPreviewProvider : CollectionPreviewParameterProvider<LevelInfo>(
    listOf(
        LevelInfo("Hello", true),
        LevelInfo("1", false),
        LevelInfo("10", true),
        LevelInfo("100", false),
    )
)