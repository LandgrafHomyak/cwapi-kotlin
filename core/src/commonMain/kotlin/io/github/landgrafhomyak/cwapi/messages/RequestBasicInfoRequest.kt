package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.Token

class RequestBasicInfoRequest(
    val token: Token,
) : Message.Client2Server {
    override fun toJson() = """{"token":${this.token.toJson()},"action":"requestBasicInfo"}"""
}
