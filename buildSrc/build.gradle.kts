plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("main-app-config-plugin") {
            id = "com.gradle.plugin.main-app-config-plugin"
            implementationClass = "com.gradle.plugin.ApplyMainConfigPlugins"
        }
    }
}
