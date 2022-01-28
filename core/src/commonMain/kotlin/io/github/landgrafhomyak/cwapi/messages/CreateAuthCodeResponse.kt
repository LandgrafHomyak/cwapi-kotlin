package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class CreateAuthCodeResponse(
    val userId: TelegramUserId,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
