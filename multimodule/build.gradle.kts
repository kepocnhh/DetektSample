import io.gitlab.arturbosch.detekt.Detekt

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.4.0"
}

repositories {
    jcenter()
}

detekt {
    toolVersion = "1.4.0"

    input = files("submodule/src/main/kotlin")

    config = files("config.yml")

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
