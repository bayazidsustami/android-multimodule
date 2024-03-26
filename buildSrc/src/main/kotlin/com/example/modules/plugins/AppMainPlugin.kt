package com.example.modules.plugins

import com.example.modules.Dependency
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppMainPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("org.jetbrains.kotlin.android")

        val androidExtension = target.project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(34)
                defaultConfig {
                    targetSdk = 34
                    minSdk = 28
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                val proguardFile = "proguard-rules.pro"
                when(this) {
                    is LibraryExtension -> defaultConfig {
                        consumerProguardFiles(proguardFile)
                    }
                    is AppExtension -> buildTypes {
                        getByName("release") {
                            isMinifyEnabled = false
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                proguardFile
                            )
                        }
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                target.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = "1.8"
                    }
                }
            }

            target.dependencies {
                add("implementation", Dependency.appCompat)
                add("implementation", Dependency.coreKtx)
                add("implementation", Dependency.materialDesign)

                add("testImplementation", Dependency.jUnit)
                add("androidTestImplementation", Dependency.jUnitExt)
                add("androidTestImplementation", Dependency.espresso)
            }
        }
    }
}