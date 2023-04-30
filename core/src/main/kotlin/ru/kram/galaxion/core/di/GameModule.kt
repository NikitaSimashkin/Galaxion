package ru.kram.galaxion.core.di

import dagger.Module
import dagger.Provides
import ru.kram.galaxion.core.base.StartSettings
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.characteristics.color.ColorProvider
import ru.kram.galaxion.core.characteristics.color.DefaultColorProvider
import ru.kram.galaxion.core.characteristics.damage.DamageProvider
import ru.kram.galaxion.core.characteristics.damage.DefaultDamageProvider
import ru.kram.galaxion.core.characteristics.direction.DefaultDirectionProvider
import ru.kram.galaxion.core.characteristics.direction.DirectionProvider
import ru.kram.galaxion.core.characteristics.hp.DefaultHpProvider
import ru.kram.galaxion.core.characteristics.hp.HpProvider
import ru.kram.galaxion.core.characteristics.position.DefaultPositionProvider
import ru.kram.galaxion.core.characteristics.position.PositionProvider
import ru.kram.galaxion.core.characteristics.size.DefaultSizeProvider
import ru.kram.galaxion.core.characteristics.size.PlaygroundObjectSizeProvider
import ru.kram.galaxion.core.characteristics.speed.DefaultSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.SpeedProvider
import ru.kram.galaxion.core.enemies.DefaultEnemyFactory
import ru.kram.galaxion.core.enemies.EnemyFactory

@Module
interface GameModule {

    companion object {
        @Provides
        @GameScope
        internal fun provideSpeedProvider(): SpeedProvider {
            return DefaultSpeedProvider()
        }

        @Provides
        @GameScope
        internal fun provideHpProvider(): HpProvider {
            return DefaultHpProvider()
        }

        @Provides
        @GameScope
        internal fun provideSizeProvider(): PlaygroundObjectSizeProvider {
            return DefaultSizeProvider()
        }

        @Provides
        @GameScope
        internal fun providePositionProvider(
			sizeProvider: PlaygroundObjectSizeProvider,
			screenSizeProvider: ScreenSizeProvider
        ): PositionProvider {
            return DefaultPositionProvider(sizeProvider, screenSizeProvider)
        }

        @Provides
        @GameScope
        internal fun provideDirectionProvider(): DirectionProvider {
            return DefaultDirectionProvider()
        }

        @Provides
        @GameScope
        internal fun provideDamageProvider(): DamageProvider {
            return DefaultDamageProvider()
        }

        @Provides
        @GameScope
        internal fun provideScreenSizeBridge(startSettings: StartSettings): ScreenSizeProvider {
            return ScreenSizeProvider(startSettings.widthPx, startSettings.heightPx)
        }

        @Provides
        @GameScope
        internal fun provideEnemyFactory(
            positionProvider: PositionProvider,
            damageProvider: DamageProvider,
            speedProvider: SpeedProvider,
            hpProvider: HpProvider,
            directionProvider: DirectionProvider,
            colorProvider: ColorProvider
        ): EnemyFactory {
            return DefaultEnemyFactory(
                positionProvider,
                damageProvider,
                speedProvider,
                hpProvider,
                directionProvider,
                colorProvider
            )
        }

        @Provides
        @GameScope
        internal fun provideColorProvider(startSettings: StartSettings): ColorProvider {
            return DefaultColorProvider(startSettings.colors)
        }
    }
}