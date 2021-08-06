plugins {
    id(Plugins.BuildPlugins.application)
    id(Plugins.BuildPlugins.kotlinAndroid)
    id(Plugins.BuildPlugins.kotlinKapt)
    id(Plugins.BuildPlugins.safeArgsPlugin)
}

android {
    compileSdk = Sdk.compileSdk
    buildToolsVersion = Plugins.Versions.buildTools
    defaultConfig {
        applicationId = "com.ninetwozero.bf5intel"
        minSdk = Sdk.minSdk
        targetSdk = Sdk.targetSdk
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = Dependencies.androidJunitRunner

        // Room schema location for generated db version
        javaCompileOptions {
            annotationProcessorOptions {
                arguments(mutableMapOf("room.schemaLocation" to "$projectDir/schemas"))
            }
        }
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {

        getByName("debug") {
            applicationIdSuffix = ".dev"
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        resources.excludes.add("META-INF/atomicfu.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":data"))

    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    //Kotlin components
    implementation(Dependencies.kotlin)
    api(Dependencies.coroutinesCore)
    api(Dependencies.coroutinesAndroid)

    //Lifecycle components
    implementation(Dependencies.lifecycleLiveDataKtx)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.lifecycleCommon)

    //Navigation components
    implementation(Dependencies.navigationFragmentKtx)
    implementation(Dependencies.navigationUIKtx)

    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.testRunner)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.archCoreTesting)
}
