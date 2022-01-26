package io.github.landgrafhomyak.cwapi.messages


sealed class ErrorMessage constructor(message: String) : Throwable(message), Message.Server2Client {
    override fun fillInStackTrace(): Throwable = this
}