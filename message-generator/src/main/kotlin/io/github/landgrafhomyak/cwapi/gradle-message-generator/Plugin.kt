package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.api.Plugin as GradlePlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class Plugin : GradlePlugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create<Scope>("cwapiMessages", target)

        with(target.tasks) {
            val codegenTask = register<Task>("cwapiMessagesGenerator") {
                group = "Code generation"
                description = "Generates messages' classes for ChatWars API"

                genSrcDir = extension.genSrcDir.asFile.resolve("")
                packageName = extension.packageName
                messageInterface = extension.messageInterface
                errorMessageBaseClass = extension.errorMessageBaseClass
                classesToGenerate = extension.classesToGenerate
            }
            target.tasks.withType<KotlinCompile>().configureEach {
                dependsOn(codegenTask)
            }
        }

    }

}