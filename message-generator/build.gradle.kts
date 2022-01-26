import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    `kotlin-dsl`
}

group = "me.admin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${getKotlinPluginVersion()}")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testRuntime("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testRuntime("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testRuntime("org.junit.platform:junit-platform-suite:1.8.2")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        register("message-generator") {
            description = "Generates messages' classes for ChatWars API"
            displayName = "CwApi message generator"
            id = "io.github.landgrafhomyak.cwapi.gradle-message-generator"
            implementationClass = "io.github.landgrafhomyak.cwapi.gradle-message-generator.Plugin"

        }
    }
}
