package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.types.Operation
import io.github.landgrafhomyak.cwapi.types.RequestId
import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class AuthAdditionalOperationResponse(
    val userId: TelegramUserId,
    val operation: Operation,
    val requestId: RequestId,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
