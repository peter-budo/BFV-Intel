object Plugins {

    object BuildPlugins {
        const val application = "com.android.application"
        const val kotlinApplication = "kotlin-android"
        const val androidExtensions = "kotlin-android-extensions"
        const val kotlinKapt = "kotlin-kapt"
        const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    const val buildTools = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    object Versions {
        const val androidGradlePlugin = "4.1.3"
        const val buildTools = "29.0.3"
    }
}