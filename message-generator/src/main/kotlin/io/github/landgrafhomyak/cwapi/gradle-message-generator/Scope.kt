package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.setValue

abstract class Scope(project: Project) {
    internal val classesToGenerate: MutableList<MessageInfo> = ArrayList()
    fun message(
        className: String,
        internalConstructor: Boolean = false,
        superClass: String? = null,
        builder: MessageBuilder.() -> Unit
    ) {
        this.classesToGenerate.add(
            MessageInfo(
                scope = MessageBuilder().also(builder),
                className = className,
                error = null,
                internalConstructor = internalConstructor,
                superClass = superClass
            )
        )
    }

    fun errorMessage(
        className: String,
        message: String,
        internalConstructor: Boolean = false,
        superClass: String? = null,
        builder: MessageBuilder.() -> Unit
    ) {
        this.classesToGenerate.add(
            MessageInfo(
                scope = MessageBuilder().also(builder),
                className = className,
                error = message,
                internalConstructor = internalConstructor,
                superClass = superClass
            )
        )
    }

    private val objects = project.objects

    var genSrcDir: Directory by objects.directoryProperty()
    var packageName: String by objects.property()
    var messageInterface: String by objects.property()
    var errorMessageBaseClass: String by objects.property()
}
