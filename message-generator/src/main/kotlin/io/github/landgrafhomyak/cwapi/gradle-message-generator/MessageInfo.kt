package io.github.landgrafhomyak.cwapi.`gradle-message-generator`

import java.io.Serializable

internal data class MessageInfo(
    val scope: MessageBuilder,
    val className: String,
    val error: String?,
    val internalConstructor: Boolean,
    val superClass: String?,
): Serializable