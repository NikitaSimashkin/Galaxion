package ru.kram.galaxion.data.di

import dagger.Module
import dagger.Provides
import ru.kram.galaxion.data.levels.LevelsInfoProvider
import ru.kram.galaxion.data.levels.LevelsInfoProviderSharedPref
import ru.kram.galaxion.data.player.PlayerInfoProvider
import ru.kram.galaxion.data.player.PlayerInfoProviderSharedPref
import ru.kram.galaxion.data.skins.SkinsInfoProvider
import ru.kram.galaxion.data.skins.SkinsInfoProviderSharedPref
import javax.inject.Scope

@Scope
annotation class DataScope

@Module
abstract class DataPlayerModule {

    companion object {
        @Provides
        @DataScope
        fun providePlayerInfoProvider(
            levelsProvider: LevelsInfoProvider,
            skinsProvider: SkinsInfoProvider
        ): PlayerInfoProvider {
            return PlayerInfoProviderSharedPref(levelsProvider, skinsProvider)
        }

        @Provides
        @DataScope
        internal fun provideLevelsInfoProvider(): LevelsInfoProvider {
            return LevelsInfoProviderSharedPref()
        }

        @Provides
        @DataScope
        internal fun provideSkinsProvider(): SkinsInfoProvider {
            return SkinsInfoProviderSharedPref()
        }
    }
}