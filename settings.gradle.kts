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

rootProject.name = "Noughty Test"
include(":app")
include(":feature:food:data")
include(":feature:food:domain")
include(":feature:food:presentation")
include(":feature:food_details:data")
include(":feature:food_details:domain")
include(":feature:food_details:presentation")
include(":core:network")
include(":core:common")
include(":core:feature_api")
