package ru.kram.galaxion.app

import android.app.Application

class GalaxionApplication: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }
}