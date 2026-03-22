plugins {
    alias(libs.plugins.kotlin)
}

group = "net.azisaba.exposed"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.adventure.api)
    compileOnly(libs.exposed.core)
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
