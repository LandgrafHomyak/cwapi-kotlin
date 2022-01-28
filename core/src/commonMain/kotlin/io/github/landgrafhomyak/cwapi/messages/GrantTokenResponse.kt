package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.types.TelegramUserId
import io.github.landgrafhomyak.cwapi.types.Token

class GrantTokenResponse(
    val token: Token,
    val userId: TelegramUserId,
    val id: String,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
