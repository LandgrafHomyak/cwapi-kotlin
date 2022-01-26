package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import groovy.json.StringEscapeUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class Task : DefaultTask() {
    @get:OutputDirectory
    lateinit var genSrcDir: File

    @get:Input
    lateinit var packageName: String

    @get:Input
    lateinit var messageInterface: String

    @get:Input
    lateinit var errorMessageBaseClass: String

    @get:Input
    internal lateinit var classesToGenerate: List<MessageInfo>

    @TaskAction
    fun invoke() {
        var destinationFolder = this.genSrcDir
        var ensure = false
        var pkgStart = 0
        this.packageName.forEachIndexed { i, c ->
            if (c == '`') {
                if (ensure) {
                    destinationFolder = destinationFolder.resolve(this.packageName.substring(pkgStart, i))
                    ensure = false
                } else {
                    ensure = true
                }
                pkgStart = i + 2
            }
            if (c == '.') {
                if (ensure) {
                    return@forEachIndexed
                }
                if (pkgStart <= i) {
                    destinationFolder = destinationFolder.resolve(this.packageName.substring(pkgStart, i))
                }
//                println(this.packageName.substring(pkgStart, i))
//                println(pkgStart)
//                println(i)
                pkgStart = i + 1
            }
        }
        if (pkgStart <= this.packageName.length) {
            destinationFolder = destinationFolder.resolve(this.packageName.substring(pkgStart, this.packageName.length))
        }
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs()
        }
        if (!destinationFolder.isDirectory) {
            throw RuntimeException("destination path for generated CwApi messages is not a directory")
        }
        destinationFolder.listFiles()!!.forEach { file -> file.delete() }
        this.classesToGenerate.map { classInfo ->
            val builder = StringBuilder()
            builder.appendLine("package " + this.packageName)
            builder.appendLine()
            builder.append("class " + classInfo.className)
            if (classInfo.internalConstructor) {
                builder.append(" internal constructor")
            }
            builder.appendLine("(")
            classInfo.scope.fields.forEach { (name, info) ->
                builder.appendLine("   var $name: ${info.second},")
            }
//            classInfo.scope.children.forEach {name, info ->
//                builder.appendLine("    var $name: ${info.}")
//            }
            builder.append(") : ")
            if (classInfo.superClass != null) {
                builder.append(classInfo.superClass)
            } else {
                if (classInfo.error != null) {
//                    println(classInfo.error)
                    builder.append("${this.errorMessageBaseClass} (message = \"${StringEscapeUtils.escapeJava(classInfo.error)}\")")
                } else {
                    builder.append(this.messageInterface)
                }
            }
            return@map classInfo.className to builder.toString()
        }.forEach { (className, generatedSourceCode) ->
            val file = destinationFolder.resolve(className + ".kt")
            if (!file.exists()) {
                file.createNewFile()
            }
            file.writeText(generatedSourceCode)
        }
    }
}