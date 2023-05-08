package ru.kram.galaxion.core.di

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import ru.kram.galaxion.core.base.Game
import ru.kram.galaxion.core.base.StartSettings
import javax.inject.Scope

@Scope
annotation class GameScope

@GameScope
@Component(modules = [GameModule::class, SpaceshipModule::class])
internal interface GameComponent {

	@Component.Factory
	interface Factory {
		fun create(
			@BindsInstance game: Game,
			@BindsInstance startSettings: StartSettings
		): GameComponent
	}

	fun inject(game: Game)
}