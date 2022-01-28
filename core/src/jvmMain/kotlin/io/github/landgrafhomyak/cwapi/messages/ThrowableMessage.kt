package io.github.landgrafhomyak.cwapi.messages

actual open class ThrowableMessage internal actual constructor(message: String) : Throwable() {
    override fun fillInStackTrace(): Throwable = this
}