@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.nazartaraniuk.natifetest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nazartaraniuk.natifetest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"nMNAxryKrTnIh0fwwKEqKmrvAzLp7J5t\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"nMNAxryKrTnIh0fwwKEqKmrvAzLp7J5t\"")
        }
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

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.gson.retrofit)

    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.runtime)

    implementation(libs.dagger)
    implementation(libs.dagger.support)

    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)
}