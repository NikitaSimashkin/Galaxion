plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

apply<ru.kram.galaxion.dependencies.DaggerDependenciesPlugin>()

@Suppress("UnstableApiUsage")
android {
    namespace = "ru.kram.galaxion.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        debug {

        }

        release {

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    with(Dependencies) {
        implementation(project(":data"))
        implementation("androidx.core:core-ktx:$androidCore")
        implementation("io.coil-kt:coil:$coil")
    }
}