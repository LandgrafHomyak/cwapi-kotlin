package io.github.landgrafhomyak.cwapi.messages

sealed class ErrorMessage(message: String): ThrowableMessage(message), Message.Server2Client