private const val kotlinVersion = "1.3.41"
private const val androidGradleVersion = "3.4.2"

private const val androidXAppCompat = "1.0.2"
private const val androidXConstraintLayout = "1.1.3"
private const val androidXCore = "1.0.2"
private const val androidXRunner = "1.2.0"
private const val androidXEspressoCore = "3.2.0"

private const val testAndroid = "1.1.1"
private const val testJunit = "4.12"
private const val testMockitoKotlin = "2.1.0"
private const val testMockito = "3.0.0"

object Dependencies {

    object Plugin {
        const val androidApplicationId = "com.android.application"
        const val kotlinAndroid = "android"
        const val kotlinAndroidExtensions = "android.extensions"
    }

    object Kotlin {
        const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val standardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:$androidXAppCompat"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$androidXConstraintLayout"
        const val core = "androidx.core:core-ktx:$androidXCore"

        object Test {
            const val runner = "androidx.test:runner:$androidXRunner"
            const val espressoCore = "androidx.test.espresso:espresso-core:$androidXEspressoCore"
        }
    }

    object Android {
        const val compileSdkVersion = 29
        const val buildToolsVersion = "29.0.1"
        const val gradle = "com.android.tools.build:gradle:$androidGradleVersion"

        object DefaultConfig {
            const val id = "alfianyusufabdullah.viewmodeltestdrive"
            const val minimalSDKVersion = 21
            const val targetSDKVersion = 29

            const val versionCode = 1
            const val versionName = "0.0.1"

            const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    object Test {
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:$testMockitoKotlin"
        const val mockitoCore = "org.mockito:mockito-core:$testMockito"
        const val mockitoInline = "org.mockito:mockito-inline:$testMockito"

        const val junit = "junit:junit:$testJunit"

        const val androidArchCore = "android.arch.core:core-testing:$testAndroid"
    }
}