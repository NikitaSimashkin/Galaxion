package ru.kram.galaxion.data.player

import ru.kram.galaxion.data.levels.LevelsInfoProvider
import ru.kram.galaxion.data.skins.SkinsInfoProvider

internal class PlayerInfoProviderSharedPref(
    private val levelsProvider: LevelsInfoProvider,
    private val skinsProvider: SkinsInfoProvider
): PlayerInfoProvider {

    override fun getPlayerInfo(): PlayerInfo {
        TODO("Not yet implemented")
    }
}