package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import java.io.Serializable

class MessageScopeBuilder internal constructor(
    internal val packageName: String,
    internal val className: String,
    internal val error: String?,
    internal val superClass: String,
) : Serializable {
    internal val fields: MutableMap<String, Pair<FieldType, String>> = HashMap()
    internal val children: MutableMap<String, MessageScopeBuilder> = HashMap()
    internal val fullClassName
        get() = "${this.packageName}.${this.className}"

    fun field(name: String, type: String, fieldClass: FieldType) = if (name !in this.fields) this.fields[name] = fieldClass to type else throw MemberDuplicateException(name)
    fun child(fieldName: String, className: String, superClass: String, scope: MessageScopeBuilder.() -> Unit) = this.child(fieldName, MessageScopeBuilder(className = className, packageName = this.packageName, superClass = superClass, error = null).also(scope))
    fun child(fieldName: String, module: MessageScopeBuilder) {
        this.field(fieldName, module.fullClassName, FieldType.Module)
        this.children[fieldName] = module
    }

}