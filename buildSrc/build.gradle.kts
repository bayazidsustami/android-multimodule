plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.2.2")
    implementation(kotlin("gradle-plugin", "1.9.0"))
}

gradlePlugin {
    plugins {
        register("base-main-plugin") {
            id = "base-main-plugin"
            implementationClass = "com.example.modules.plugins.AppMainPlugin"
        }
    }
}
