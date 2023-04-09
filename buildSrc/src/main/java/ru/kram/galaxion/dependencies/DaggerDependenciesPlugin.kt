package ru.kram.galaxion.dependencies

import Dependencies
import org.gradle.api.Plugin
import org.gradle.api.Project

class DaggerDependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = with(Dependencies){
        project.dependencies.apply {
            add(IMPLEMENTATION, "com.google.dagger:dagger:$dagger")
            add(KAPT, "com.google.dagger:dagger-compiler:$dagger")
            add(KAPT, "com.google.dagger:dagger-android-processor:$dagger")
        }
    }

    companion object {
        private const val IMPLEMENTATION = "implementation"
        private const val KAPT = "kapt"
    }
}