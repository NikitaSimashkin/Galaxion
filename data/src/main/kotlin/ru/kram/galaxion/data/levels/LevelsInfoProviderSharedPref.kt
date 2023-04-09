package ru.kram.galaxion.data.levels

internal class LevelsInfoProviderSharedPref(): LevelsInfoProvider {

    override fun getLevelsInfo(): List<LevelInfo> {
        return listOf(
            LevelInfo("1", true),
            LevelInfo("2", true),
            LevelInfo("3", false),
            LevelInfo("4", false),
            LevelInfo("5", false),
            LevelInfo("6", false),
            LevelInfo("7", false),
            LevelInfo("8", false),
            LevelInfo("9", false),
            LevelInfo("10", false),
            LevelInfo("11", false),
            LevelInfo("12", false),
        )
    }
}