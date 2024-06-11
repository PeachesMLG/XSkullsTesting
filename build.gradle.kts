plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.iridium"
version = "1.0.0"
description = "XSkullsTest"

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://libraries.minecraft.net")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("com.github.cryptomorin:XSeries:11.0.0") { isTransitive = false }

    // Other dependencies that are not required or already available at runtime
    compileOnly("org.projectlombok:lombok:1.18.32")
    compileOnly("org.spigotmc:spigot-api:1.20.6-R0.1-SNAPSHOT")
    compileOnly("com.mojang:authlib:1.5.25")

    // Enable lombok annotation processing
    annotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks {
    jar {
        dependsOn("shadowJar")
        enabled = false
    }

    shadowJar {
        relocate("com.cryptomorin.xseries", "com.iridium.xskullstest.dependencies.xseries")

        archiveClassifier.set("")

        minimize()
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        filesMatching("**/plugin.yml") {
            expand(rootProject.project.properties)
        }

        outputs.upToDateWhen { false }
    }

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }
}