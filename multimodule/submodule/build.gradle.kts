plugins {
    application
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    jcenter()
}

application {
    mainClassName = "detekt.sample.AppKt"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.61")
}
