import io.github.landgrafhomyak.cwapi.`gradle-message-generator`.FieldType

plugins {
    kotlin("jvm") version "1.6.10"
    id("io.github.landgrafhomyak.cwapi.gradle-message-generator")
    idea
}

group = "io.github.landgrafhomyak"
version = "1!2022.1.25a0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

val generatedSourceDir = layout.projectDirectory.dir("src/main/generatedKotlin")//buildDir.resolve("generated")


cwapiMessages {
    packageName = "io.github.landgrafhomyak.cwapi.messages"
    genSrcDir = generatedSourceDir
    messageInterface = "$packageName.Message"
    errorMessageBaseClass = "$packageName.ErrorMessage"

    message(
        className = "CreateAuthCodeRequest",
        superClass = "io.github.landgrafhomyak.cwapi.messages.Message.Client2Server"
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
    }
    message(
        className = "GrantTokenRequest",
        superClass = "io.github.landgrafhomyak.cwapi.messages.Message.Client2Server"
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("authCode", "io.github.landgrafhomyak.cwapi.types.AuthCode", FieldType.String)
    }
    message(
        className = "GrantTokenRequest",
        superClass = "io.github.landgrafhomyak.cwapi.messages.Message.Client2Server"
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("authCode", "io.github.landgrafhomyak.cwapi.types.AuthCode", FieldType.String)
    }
}

sourceSets {
    this["main"].apply {
        java.srcDir(generatedSourceDir)
    }
}
idea {
    module {
        generatedSourceDirs.add(generatedSourceDir.asFile)
    }
}
kotlin {
}