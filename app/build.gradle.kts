plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

apply<ru.kram.galaxion.dependencies.DaggerDependenciesPlugin>()
apply<ru.kram.galaxion.dependencies.JetpackComposeDependenciesPlugin>()

@Suppress("UnstableApiUsage")
android {
    namespace = "ru.kram.galaxion"
    compileSdk = 33

    defaultConfig {
        applicationId  = "ru.kram.galaxion"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        debug {

        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
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

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.compose
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
        implementation(project(":core"))

        implementation("androidx.core:core-ktx:$androidCore")
        implementation("androidx.appcompat:appcompat:$appCompat")

        implementation("com.google.android.material:material:$material")
        implementation("androidx.constraintlayout:constraintlayout:$constraintLayout")

        // Junit
        testImplementation("junit:junit:$junit")
        androidTestImplementation("androidx.test.ext:junit:$androidJunit")

        // ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModel")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$viewModel")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:$viewModel")

        // Espresso
        androidTestImplementation("androidx.test.espresso:espresso-core:$espresso")

        // Coil
        implementation("io.coil-kt:coil-compose:$coil")
    }
}