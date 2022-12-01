import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val internalDependencies = listOf("refrakt", "akt")

repositories {

    maven {
        url = uri("https://maven.pkg.github.com/kieranipalmer/refrakt")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USER")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }

    maven {
        url = uri("https://maven.pkg.github.com/kieranipalmer/akt")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USER")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }

    mavenCentral()
}

dependencies {

    //Internal
    implementation("dev.shanty:refrakt:0.0.1")
    implementation("dev.shanty:akt:0.0.2")

    //Ktor

    implementation("io.ktor:ktor-server-core-jvm:2.1.3")
    implementation("io.ktor:ktor-server-netty-jvm:2.1.3")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}