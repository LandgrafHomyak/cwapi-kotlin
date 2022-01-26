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

    val MessageSuperclass = object {
        val Client2Server = "io.github.landgrafhomyak.cwapi.messages.Message.Client2Server"
        val Server2Client = "io.github.landgrafhomyak.cwapi.messages.Message.Server2Client"
    }

    message(
        className = "CreateAuthCodeRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
    }

    message(
        className = "GrantTokenRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("authCode", "io.github.landgrafhomyak.cwapi.types.AuthCode", FieldType.String)
    }

    message(
        className = "AuthAdditionalOperationRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
        field("operation", "io.github.landgrafhomyak.cwapi.types.Operation", FieldType.Enum)
    }

    message(
        className = "GrantAdditionalOperationRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
        field("requestId", "io.github.landgrafhomyak.cwapi.types.RequestId", FieldType.String)
        field("authCode", "io.github.landgrafhomyak.cwapi.types.AuthCode", FieldType.String)
    }

    message(
        className = "GetInfoRequest",
        superClass = MessageSuperclass.Client2Server
    ) {}

    message(
        className = "ViewCraftbookRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "RequestProfileRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "RequestBasicInfoRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "RequestGearInfoRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "RequestStockRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "GuildInfoRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "WantToBuyRequest",
        superClass = MessageSuperclass.Client2Server
    ) {
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
        field("itemCode", "io.github.landgrafhomyak.cwapi.types.ItemCode", FieldType.String)
        field("quantity", "kotlin.ULong", FieldType.Number)
        field("price", "kotlin.ULong", FieldType.Number)
        field("exactPrice", "kotlin.Boolean", FieldType.Boolean)
    }

    message(
        className = "CreateAuthCodeResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
    }

    message(
        className = "GrantTokenResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("id", "kotlin.String", FieldType.String)
        field("token", "io.github.landgrafhomyak.cwapi.types.Token", FieldType.String)
    }

    message(
        className = "AuthAdditionalOperationResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("operation", "io.github.landgrafhomyak.cwapi.types.Operation", FieldType.Enum)
        field("requestId", "io.github.landgrafhomyak.cwapi.types.RequestId", FieldType.String)
    }

    message(
        className = "GrantAdditionalOperationResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("requestId", "io.github.landgrafhomyak.cwapi.types.RequestId", FieldType.String)
    }

    message(
        className = "GetInfoResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("balance", "kotlin.Long", FieldType.Number)
    }

    message(
        className = "ViewCraftbookResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        /* todo */
    }

    message(
        className = "RequestBasicInfoResponse",
        superClass = MessageSuperclass.Server2Client
    ) {
        field("userId", "io.github.landgrafhomyak.cwapi.types.TelegramUserId", FieldType.Number)
        field("class_", "io.github.landgrafhomyak.cwapi.types.Class", FieldType.Enum)
        field("def", "kotlin.ULong", FieldType.Number)

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