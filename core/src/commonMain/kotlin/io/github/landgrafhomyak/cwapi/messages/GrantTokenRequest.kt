package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.AuthCode
import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class GrantTokenRequest(
    val userId: TelegramUserId,
    val authCode: AuthCode,
) : Message.Client2Server {
    override fun toJson() = """{"action":"grantToken","payload":{"userId":${this.userId.toJson()},"authCode":${this.authCode.toJson()}}}"""
}
