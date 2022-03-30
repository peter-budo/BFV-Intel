// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.buildTools)
        classpath(Dependencies.kotlinGradlePlugin)
        classpath(Dependencies.safeArgs)
        classpath(Plugins.kotlinGradlePlugin)
        classpath("com.android.tools.build:gradle:7.1.2")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
