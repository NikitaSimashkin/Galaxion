package ru.kram.galaxion.data.player

import ru.kram.galaxion.data.levels.LevelInfo
import ru.kram.galaxion.data.skins.SkinInfo

data class PlayerInfo(
    val name: String,
    val levels: List<LevelInfo>,
    val skins: List<SkinInfo>
)
