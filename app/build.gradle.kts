plugins {
    id(Plugins.BuildPlugins.application)
    id(Plugins.BuildPlugins.kotlinApplication)
    id(Plugins.BuildPlugins.androidExtensions)
    id(Plugins.BuildPlugins.kotlinKapt)
    id(Plugins.BuildPlugins.safeArgsPlugin)
}

android {
    compileSdkVersion(Sdk.compileSdk)
    buildToolsVersion(Plugins.Versions.buildTools)
    defaultConfig {
        applicationId("com.ninetwozero.bf5intel")
        minSdkVersion(Sdk.minSdk)
        targetSdkVersion(Sdk.targetSdk)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner(Dependencies.androidJunitRunner)
    }

    buildTypes {

        getByName("debug") {
            applicationIdSuffix(".dev")
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        exclude("META-INF/atomicfu.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    //Kotlin components
    implementation(Dependencies.kotlin)
    api(Dependencies.coroutinesCore)
    api(Dependencies.coroutinesAndroid)

    // Room components
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
    androidTestImplementation(Dependencies.roomTesting)

    //Lifecycle components
    implementation(Dependencies.lifecycleExtensions)
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
