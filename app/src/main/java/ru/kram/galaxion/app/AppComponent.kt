package ru.kram.galaxion.app

import dagger.BindsInstance
import dagger.Component
import ru.kram.galaxion.data.di.DataPlayerModule
import javax.inject.Scope

@Scope
annotation class AppScope

@AppScope
@Component(
    modules = [
        DataPlayerModule::class,

    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GalaxionApplication): AppComponent
    }
}