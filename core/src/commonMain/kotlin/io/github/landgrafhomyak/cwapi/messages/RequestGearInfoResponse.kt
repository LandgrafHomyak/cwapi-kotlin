package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.JsonSerializable
import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.*

class RequestGearInfoResponse(
    val userId: TelegramUserId,
    val head: Gear?,
    val body: Gear?,
    val hands: Gear?,
    val feet: Gear?,

    val coat: Gear?,

    val amulet: Gear?,
    val ring: Gear?
) : JsonSerializable {
    override fun toJson() = TODO("Not implemented")
}