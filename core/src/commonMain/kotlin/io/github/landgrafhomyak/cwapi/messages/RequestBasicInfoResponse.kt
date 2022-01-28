package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.Class
import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class RequestBasicInfoResponse(
    val userId: TelegramUserId,
    val `class`: Class,
    val atk: ULong,
    val def: ULong,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
