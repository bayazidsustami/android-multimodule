plugins {
    id("com.android.library")
    id("base-main-plugin")
}

android {
    namespace = "com.example.features.checkout"
}

dependencies {
    implementation(project(":common_features:common_features_checkout"))
    implementation(project(":commons:common_kotlin"))
    implementation(project(":commons:common_android"))
    implementation(project(":core:network"))
    implementation(project(":core:analytics"))
}