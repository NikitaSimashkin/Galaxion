package ru.kram.galaxion.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.kram.galaxion.core.base.SpaceshipController
import ru.kram.galaxion.core.base.SpaceshipControllerImpl
import ru.kram.galaxion.core.characteristics.direction.DefaultDirectionProvider
import ru.kram.galaxion.core.characteristics.direction.SpaceshipDirectionProvider
import ru.kram.galaxion.core.characteristics.direction.SpaceshipDirectionProviderImpl
import ru.kram.galaxion.core.characteristics.speed.DefaultSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.SpaceshipSpeedProvider
import ru.kram.galaxion.core.characteristics.speed.SpaceshipSpeedProviderImpl

@Module
internal interface SpaceshipModule {

	companion object {
		@Provides
		@GameScope
		fun provideSpaceshipController(
			spaceshipDirectionProvider: SpaceshipDirectionProvider,
			spaceshipSpeedProvider: SpaceshipSpeedProvider
		): SpaceshipController {
			return SpaceshipControllerImpl(spaceshipSpeedProvider, spaceshipDirectionProvider)
		}

		@Provides
		@GameScope
		fun provideSpaceshipSpeedProvider(): SpaceshipSpeedProvider {
			return SpaceshipSpeedProviderImpl()
		}

		@Provides
		@GameScope
		fun provideSpaceshipDirectionProvider(): SpaceshipDirectionProvider {
			return SpaceshipDirectionProviderImpl()
		}
	}
}