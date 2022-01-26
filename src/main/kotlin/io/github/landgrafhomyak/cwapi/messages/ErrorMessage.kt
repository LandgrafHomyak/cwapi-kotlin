package io.github.landgrafhomyak.cwapi.messages


sealed class ErrorMessage(message: String) : Throwable(message), Message.Server2Client