package com.example.modules.plugins

import com.android.build.api.dsl.CommonExtension
import com.example.modules.Dependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {

        val androidExtension = target.project.extensions.getByName("android")
        if (androidExtension is CommonExtension<*, *, *, *, *>) {
            androidExtension.apply {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.1"
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }
        }

        target.dependencies {
            add("implementation", Dependency.coreKtx)
            add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
            add("implementation", "androidx.activity:activity-compose:1.8.2")
            add("implementation", platform("androidx.compose:compose-bom:2023.08.00"))
            add("implementation", "androidx.compose.ui:ui")
            add("implementation", "androidx.compose.ui:ui-graphics")
            add("implementation", "androidx.compose.ui:ui-tooling-preview")
            add("implementation", "androidx.compose.material3:material3")
            add("androidTestImplementation", platform("androidx.compose:compose-bom:2023.08.00"))
            add("androidTestImplementation", "androidx.compose.ui:ui-test-junit4")
            add("debugImplementation", "androidx.compose.ui:ui-tooling")
            add("debugImplementation", "androidx.compose.ui:ui-test-manifest")
        }
    }

}