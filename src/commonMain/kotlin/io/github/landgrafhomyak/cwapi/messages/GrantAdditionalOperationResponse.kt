package io.github.landgrafhomyak.cwapi.messages

class GrantAdditionalOperationResponse(
   var requestId: io.github.landgrafhomyak.cwapi.types.RequestId,
   var userId: io.github.landgrafhomyak.cwapi.types.TelegramUserId,
) : io.github.landgrafhomyak.cwapi.messages.Message.Server2Client {
    override fun dump() = ""
}
