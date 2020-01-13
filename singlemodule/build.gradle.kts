import io.gitlab.arturbosch.detekt.Detekt

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

plugins {
    id("org.gradle.application")
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
    id("io.gitlab.arturbosch.detekt") version "1.4.0"
}

detekt {
    toolVersion = "1.4.0"

    input = files("src/main/kotlin")

    config = files("src/main/resources/detekt/config.yml")

    reports {
        html {
            enabled = true
            destination = File("./quality.html")
        }
        xml.enabled = false
        txt.enabled = false
    }
}

tasks {
    withType<Detekt> {
        this.jvmTarget = "1.8"
    }
}

application {
    mainClassName = "detekt.sample.AppKt"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.61")
}
