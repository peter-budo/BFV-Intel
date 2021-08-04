object Plugins {

    object BuildPlugins {
        const val application = "com.android.application"
        const val kotlinApplication = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    const val buildTools = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    object Versions {
        const val androidGradlePlugin = "7.0.0"
        const val buildTools = "30.0.3"
    }
}