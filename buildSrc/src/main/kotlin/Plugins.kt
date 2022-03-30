object Plugins {

    object BuildPlugins {
        const val application = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val androidLibrary = "com.android.library"
        const val kotlinKapt = "kotlin-kapt"
        const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    const val buildTools = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"

    object Versions {
        const val androidGradlePlugin = "7.1.2"
        const val kotlinGradlePlugin = "1.6.10"
        const val buildTools = "30.0.3"
    }
}