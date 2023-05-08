package ru.kram.galaxion.core.di

import dagger.Module
import dagger.Provides
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.core.base.GameObject
import ru.kram.galaxion.core.base.GameThread
import ru.kram.galaxion.core.base.StartSettings
import ru.kram.galaxion.core.screen.ScreenSizeProvider
import ru.kram.galaxion.core.characteristics.color.ColorProvider
import ru.kram.galaxion.core.characteristics.color.DefaultColorProvider
import ru.kram.galaxion.core.characteristics.damage.StartDamageProvider
import ru.kram.galaxion.core.characteristics.damage.DefaultDamageProvider
import ru.kram.galaxion.core.characteristics.direction.DefaultDirectionProvider
import ru.kram.galaxion.core.characteristics.direction.StartDirectionProvider
import ru.kram.galaxion.core.characteristics.hp.DefaultHpProvider
import ru.kram.galaxion.core.characteristics.hp.StartHpProvider
import ru.kram.galaxion.core.characteristics.position.DefaultPositionProvider
import ru.kram.galaxion.core.characteristics.position.StartPositionProvider
import ru.kram.galaxion.core.characteristics.size.DefaultSizeProvider
import ru.kram.galaxion.core.characteristics.size.StartSizeProvider
import ru.kram.galaxion.core.characteristics.speed.DefaultSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.SpaceshipSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.StartSpeedProvider
import ru.kram.galaxion.core.enemies.DefaultGameObjectFactory
import ru.kram.galaxion.core.enemies.GameObjectFactory
import ru.kram.galaxion.core.image.ImageProvider
import ru.kram.galaxion.core.image.ImageStorage

@Module
interface GameModule {

    companion object {

		@Provides
		@GameScope
		internal fun provideGameThread(game: Game, startSettings: StartSettings): GameThread {
			return GameThread(game, startSettings.fpsCounter)
		}

        @Provides
        @GameScope
        internal fun provideSpeedProvider(): StartSpeedProvider {
            return DefaultSpeedProvider()
        }

        @Provides
        @GameScope
        internal fun provideHpProvider(): StartHpProvider {
            return DefaultHpProvider()
        }

        @Provides
        @GameScope
        internal fun provideSizeProvider(): StartSizeProvider {
            return DefaultSizeProvider()
        }

        @Provides
        @GameScope
        internal fun providePositionProvider(
			startSizeProvider: StartSizeProvider
        ): StartPositionProvider {
            return DefaultPositionProvider(startSizeProvider)
        }

        @Provides
        @GameScope
        internal fun provideDirectionProvider(): StartDirectionProvider {
            return DefaultDirectionProvider()
        }

        @Provides
        @GameScope
        internal fun provideDamageProvider(): StartDamageProvider {
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
			startPositionProvider: StartPositionProvider,
			startDamageProvider: StartDamageProvider,
			startSpeedProvider: StartSpeedProvider,
			startHpProvider: StartHpProvider,
			startDirectionProvider: StartDirectionProvider,
			colorProvider: ColorProvider
        ): GameObjectFactory {
            return DefaultGameObjectFactory(
                startPositionProvider,
                startDamageProvider,
                startSpeedProvider,
                startHpProvider,
                startDirectionProvider,
                colorProvider
            )
        }

        @Provides
        @GameScope
        internal fun provideColorProvider(startSettings: StartSettings): ColorProvider {
            return DefaultColorProvider(startSettings.colors)
        }

		@Provides
		@GameScope
		internal fun provideImageStorage(startSettings: StartSettings): ImageStorage {
			val res = startSettings.enemyNumber.keys.flatMap { ImageProvider.getImages(it).values }.toMutableList()
			res.addAll(ImageProvider.getImages(GameObject.Spaceship).values)
			return ImageStorage(res)
		}
    }
}