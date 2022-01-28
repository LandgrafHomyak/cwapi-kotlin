package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.types.RequestId
import io.github.landgrafhomyak.cwapi.types.TelegramUserId

class GrantAdditionalOperationResponse(
    val userId: TelegramUserId,
    val requestId: RequestId,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
