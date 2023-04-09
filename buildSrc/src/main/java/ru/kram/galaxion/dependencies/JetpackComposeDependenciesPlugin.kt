package ru.kram.galaxion.dependencies

import Dependencies
import org.gradle.api.Plugin
import org.gradle.api.Project

class JetpackComposeDependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = with(Dependencies){
        project.dependencies.apply {
            add(IMPLEMENTATION, "androidx.activity:activity-compose:$activityCompose")
            add(IMPLEMENTATION,  "androidx.compose.ui:ui:$compose")
            add(IMPLEMENTATION, "androidx.compose.ui:ui-tooling-preview:$compose")
            add(IMPLEMENTATION, "androidx.compose.material:material:$compose")
            add(IMPLEMENTATION, "androidx.compose.runtime:runtime-livedata:$compose")
            add(IMPLEMENTATION, "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutCompose")
            add(IMPLEMENTATION,"androidx.lifecycle:lifecycle-viewmodel-compose:$viewModel")
            add(IMPLEMENTATION, "androidx.navigation:navigation-compose:$navigationCompose")

            add(DEBUG_IMPLEMENTATION, "androidx.compose.ui:ui-tooling:$compose")
            add(ANDROID_TEST_IMPLEMENTATION, "androidx.compose.ui:ui-test-junit4:$compose")
            add(DEBUG_IMPLEMENTATION, "androidx.compose.ui:ui-tooling:$compose")
            add(DEBUG_IMPLEMENTATION, "androidx.compose.ui:ui-test-manifest:$compose")
        }
    }

    companion object {
        private const val IMPLEMENTATION = "implementation"
        private const val DEBUG_IMPLEMENTATION = "debugImplementation"
        private const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
    }
}