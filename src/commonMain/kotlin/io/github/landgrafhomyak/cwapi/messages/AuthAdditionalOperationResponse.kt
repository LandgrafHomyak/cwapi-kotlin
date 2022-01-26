package io.github.landgrafhomyak.cwapi.messages

class AuthAdditionalOperationResponse(
   var requestId: io.github.landgrafhomyak.cwapi.types.RequestId,
   var userId: io.github.landgrafhomyak.cwapi.types.TelegramUserId,
   var operation: io.github.landgrafhomyak.cwapi.types.Operation,
) : io.github.landgrafhomyak.cwapi.messages.Message.Server2Client {
    override fun dump() = ""
}
