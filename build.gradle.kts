plugins {
    `kotlin-dsl`
}

buildscript {

    dependencies {
        classpath("com.android.tools.build:gradle:${Dependencies.androidGradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlin}")
    }
}