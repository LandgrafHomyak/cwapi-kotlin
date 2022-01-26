package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import java.lang.StringBuilder

internal class MessageClassGenerator(private val meta: MessageScopeBuilder) {
    private val builder = StringBuilder()
    fun export(): String = builder.toString()

    init {
        this.builder.appendLine("package ${this.meta.packageName}")
        this.builder.appendLine()
        this.builder.appendLine("class ${this.meta.className}(")
        for ((fieldName, fieldMeta) in this.meta.fields) {
            this.builder.appendLine("   var $fieldName: ${fieldMeta.second}")
        }
        this.builder.appendLine(") : ${this.meta.superClass}")
    }
}