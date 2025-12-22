import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.20"

}
android {
    namespace = "com.robert.cryptro"
    compileSdk {
        version = release(36)
    }


    defaultConfig {
        applicationId = "com.robert.cryptro"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        val localProperties = Properties().apply {
            load(project.rootProject.file("local.properties").inputStream())
        }


        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://rest.coincap.io/v3/\""
            )
            buildConfigField(
                "String",
                "API_KEY",
                "\"${localProperties.getProperty("API_KEY", "")}\"")

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://rest.coincap.io/v3/\""
            )
            buildConfigField(
                "String",
                "API_KEY",
                "\"${localProperties.getProperty("API_KEY", "")}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
       buildConfig = true
    }


}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.4")
    implementation(libs.androidx.compose.material.icons.core)
    implementation("io.insert-koin:koin-android:4.1.1")
    implementation("io.insert-koin:koin-androidx-navigation:4.1.1")
    implementation("io.insert-koin:koin-androidx-compose:4.1.1")

    implementation("io.ktor:ktor-client-android:3.3.1")
    implementation("io.ktor:ktor-client-core:3.3.1")
    implementation("io.ktor:ktor-client-okhttp:3.3.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.3.1")
    implementation("io.ktor:ktor-client-serialization-jvm:3.3.1")
    implementation("io.ktor:ktor-client-logging:3.3.1")
    implementation ("io.ktor:ktor-client-content-negotiation:3.3.1")
    implementation("io.ktor:ktor-client-cio:3.3.1")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
    // Coroutines - Deferred adapter
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:3.0.0") // أو أحدث إصدار

// OkHttp
    implementation("com.squareup.okhttp3:okhttp:5.2.1")
    implementation("com.squareup.okhttp3:logging-interceptor:5.2.1")

// Kotlinx Serialization Converter for Retrofit
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    //adaptive
        implementation("androidx.compose.material3.adaptive:adaptive:1.3.0-alpha05")
        implementation("androidx.compose.material3.adaptive:adaptive-layout:1.3.0-alpha05")
        implementation("androidx.compose.material3.adaptive:adaptive-navigation:1.3.0-alpha05")



}