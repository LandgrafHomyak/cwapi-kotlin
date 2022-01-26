package io.github.landgrafhomyak.cwapi.messages


sealed interface Message {
    sealed interface Client2Server : Message
    sealed interface Server2Client : Message

    fun dump(): String
}