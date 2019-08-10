plugins {
    id(Plugin.androidApplicationId)
    kotlin(Plugin.kotlinAndroid)
    kotlin(Plugin.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(Android.compileSdkVersion)
    buildToolsVersion(Android.buildToolsVersion)
    defaultConfig {
        applicationId = Android.DefaultConfig.id
        minSdkVersion(Android.DefaultConfig.minimalSDKVersion)
        targetSdkVersion(Android.DefaultConfig.targetSDKVersion)
        versionCode = Android.DefaultConfig.versionCode
        versionName = Android.DefaultConfig.versionName
        testInstrumentationRunner = Android.DefaultConfig.testInstrumentationRunner
    }
    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(
        fileTree("dir" to "libs", "include" to listOf("*.jar"))
    )
    implementation(Kotlin.standardLibrary)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.constraintLayout)

    testImplementation(Dependencies.Test.mockitoKotlin)
    testImplementation(Dependencies.Test.mockitoCore)
    testImplementation(Dependencies.Test.mockitoInline)

    testImplementation(Dependencies.Test.androidArchCore)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.AndroidX.Test.runner)
    androidTestImplementation(Dependencies.AndroidX.Test.espressoCore)

}
