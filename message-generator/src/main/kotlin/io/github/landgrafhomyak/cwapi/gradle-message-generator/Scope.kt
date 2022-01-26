package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.setValue

abstract class Scope(project: Project) {
    internal val classesToGenerate: MutableList<MessageScopeBuilder> = ArrayList()
    fun message(
        className: String,
//        internalConstructor: Boolean = false,
        superClass: String,
        builder: MessageScopeBuilder.() -> Unit
    ) {
        this.classesToGenerate.add(
            MessageScopeBuilder(
                packageName = this.packageName,
                className = className,
                error = null,
                superClass = superClass
            ).also(builder)
        )
    }

    fun errorMessage(
        className: String,
        message: String,
//        internalConstructor: Boolean = false,
        superClass: String,
        builder: MessageScopeBuilder.() -> Unit
    ) {
        this.classesToGenerate.add(
            MessageScopeBuilder(
                packageName = this.packageName,
                className = className,
                error = message,
                superClass = superClass
            ).also(builder)
        )
    }

    private val objects = project.objects

    var genSrcDir: Directory by objects.directoryProperty()
    var packageName: String by objects.property()
    var messageInterface: String by objects.property()
    var errorMessageBaseClass: String by objects.property()
}
