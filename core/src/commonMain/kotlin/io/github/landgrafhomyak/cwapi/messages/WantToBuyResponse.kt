package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.JsonSerializable
import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.*

class WantToBuyResponse(
    val userId: TelegramUserId,
    val itemName: String,
    val quantity: ULong
) : Message.Server2Client {

    override fun toJson() = TODO("Not implemented")
}