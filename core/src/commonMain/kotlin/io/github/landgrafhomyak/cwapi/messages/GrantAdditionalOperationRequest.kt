package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.AuthCode
import io.github.landgrafhomyak.cwapi.types.RequestId
import io.github.landgrafhomyak.cwapi.types.Token

class GrantAdditionalOperationRequest(
    val token: Token,
    val requestId: RequestId,
    val authCode: AuthCode,
) : Message.Client2Server {
    override fun toJson() = """{"token":${this.token.toJson()},"action":"grantAdditionalOperation","payload":{"requestId":${this.requestId.toJson()},"authCode":${this.authCode.toJson()}}}"""
}
