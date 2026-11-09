plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.appweek10"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.appweek10"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // https://developer.android.com/develop/ui/views/layout/recyclerview?hl=ko#kotlin

    // ViewBinding Activate
    // pros : 1) 타입 안정성, 2) Null 안정성, 3) findViewByID 반복 제거, 4) 성능
    // cons : 1) 빌드 시간 증가, 2) 바인딩 객체 생성 필요, 3) 학습 곡선
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}