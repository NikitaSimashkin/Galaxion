pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven { url  = uri("https://jitpack.io") }
    }
}

rootProject.name = "Galaxion"
include (
    ":app",
    ":data",
    ":core"
)
