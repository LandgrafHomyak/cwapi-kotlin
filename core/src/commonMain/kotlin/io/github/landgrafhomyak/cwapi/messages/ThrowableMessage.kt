package io.github.landgrafhomyak.cwapi.messages

@Deprecated(
    message = "Class for internal use",
    replaceWith = ReplaceWith("ErrorMessage")
)
expect open class ThrowableMessage internal constructor(message: String) : Throwable