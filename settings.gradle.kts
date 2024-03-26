pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// select configs as needed
rootProject.name = "Multi Module"
//apply("./config/config_main.gradle")
apply("./config/config_feature_home.gradle")
//apply("./config/config_feature_checkout.gradle")
//apply("./config/config_feature_catalogue.gradle")
