plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.dokka") version "1.9.10"
}

val ext = project.extensions

ext.extraProperties["mapkitApiKey"] = getMapkitApiKey()

fun getMapkitApiKey(): String {
    val properties = java.util.Properties()
    project.file("local.properties").inputStream().use { properties.load(it) }
    return properties.getProperty("MAPKIT_API_KEY", "")
}

