pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Smart Life Academy"
include(":app")

// Include the Flutter module (assumes it is created one level up as 'smart_life_flutter')
val flutterProjectRoot = file("../smart_life_flutter")
val flutterSettings = File(flutterProjectRoot, ".android/include_flutter.groovy")
if (flutterSettings.exists()) {
    apply(from = flutterSettings)
}
 