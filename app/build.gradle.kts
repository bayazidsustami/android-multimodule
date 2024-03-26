plugins {
    id("com.android.application")
    id("base-main-plugin")
    id("base-compose-plugin")
}

android {
    namespace = "com.example.multimodule"

    defaultConfig {
        applicationId = "com.example.multimodule"
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {

    //module implementation
    implementation(project(":features:home"))
    implementation(project(":features:catalogue"))
    implementation(project(":features:checkout"))
}