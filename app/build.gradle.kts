plugins {
    id(Dependencies.Plugin.androidApplicationId)
    kotlin(Dependencies.Plugin.kotlinAndroid)
    kotlin(Dependencies.Plugin.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion(Dependencies.Android.buildToolsVersion)
    defaultConfig {
        applicationId = Dependencies.Android.DefaultConfig.id
        minSdkVersion(Dependencies.Android.DefaultConfig.minimalSDKVersion)
        targetSdkVersion(Dependencies.Android.DefaultConfig.targetSDKVersion)
        versionCode = Dependencies.Android.DefaultConfig.versionCode
        versionName = Dependencies.Android.DefaultConfig.versionName
        testInstrumentationRunner = Dependencies.Android.DefaultConfig.testInstrumentationRunner
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
    implementation(Dependencies.Kotlin.standardLibrary)
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
