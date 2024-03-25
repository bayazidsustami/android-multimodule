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

rootProject.name = "Multi Module"
include(":app")
include(":features:home")
include(":features:catalogue")
include(":commons:common_kotlin")
include(":commons:common_android")
include(":core:network")
