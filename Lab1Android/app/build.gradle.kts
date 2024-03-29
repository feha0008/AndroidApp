plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.lab1android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.lab1android"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.navigation:navigation-fragment:2.5.3")
    implementation("androidx.navigation:navigation-ui:2.5.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.android.volley:volley:1.2.1")
    implementation("com.squareup.retrofit2:converter-jackson:2.7.2") //Jackson dependency
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3") //Jackson dependency
    implementation("com.fasterxml.jackson.core:jackson-core:2.10.3") //Jackson dependency
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.10.3") //Jackson dependency
    implementation("javax.annotation:javax.annotation-api:1.3.2") //Jackson dependency
}