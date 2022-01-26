package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import java.io.Serializable
import kotlin.reflect.KClass

class MessageBuilder internal constructor() : Serializable {
    internal val fields: MutableMap<String, Pair<FieldType, String>> = HashMap()
    internal val children: MutableMap<String, MessageBuilder> = HashMap()

    private operator fun contains(name: String) = (name in this.fields) or (name in this.children)

    fun child(name: String, scope: MessageBuilder.() -> Unit) = if (name !in this) this.children[name] = MessageBuilder().also(scope) else throw MemberDuplicateException(name)
    fun field(name: String, type: String, fieldClass: FieldType) = if (name !in this) this.fields[name] = fieldClass to type else throw MemberDuplicateException(name)
}