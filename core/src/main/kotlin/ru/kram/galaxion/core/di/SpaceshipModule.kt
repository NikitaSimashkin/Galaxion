package ru.kram.galaxion.core.di

import dagger.Module
import dagger.Provides
import ru.kram.galaxion.core.spaceship.SpaceshipDirectionProvider
import ru.kram.galaxion.core.spaceship.SpaceshipDirectionProviderImpl
import ru.kram.galaxion.core.spaceship.SpaceshipSpeedProvider
import ru.kram.galaxion.core.spaceship.SpaceshipSpeedProviderImpl

@Module
internal interface SpaceshipModule {

	companion object {

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