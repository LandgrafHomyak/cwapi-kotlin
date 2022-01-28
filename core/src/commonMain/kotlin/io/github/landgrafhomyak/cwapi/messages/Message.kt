package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.JsonSerializable


sealed interface Message : JsonSerializable {
    sealed interface Client2Server : Message
    sealed interface Server2Client : Message
}