package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class CreateAuthCodeRequest(
    val userId: TelegramUserId,
) : Message.Client2Server {
    override fun toJson() = """{"action":"createAuthCode","payload":{"userId":${this.userId.toJson()}}}"""
}
