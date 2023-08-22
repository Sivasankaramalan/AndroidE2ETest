plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mercari.e2etest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mercari.e2etest"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    // Needed for JUnit tests
    testImplementation("junit:junit:4.13.2")

    // Needed for Android instrumentation tests
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Needed for Compose UI tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0")

    // Other Android dependencies
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
