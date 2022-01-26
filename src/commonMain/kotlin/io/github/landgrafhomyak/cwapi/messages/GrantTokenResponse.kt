package io.github.landgrafhomyak.cwapi.messages

class GrantTokenResponse(
   var id: kotlin.String,
   var userId: io.github.landgrafhomyak.cwapi.types.TelegramUserId,
   var token: io.github.landgrafhomyak.cwapi.types.Token,
) : io.github.landgrafhomyak.cwapi.messages.Message.Server2Client {
    override fun dump() = ""
}
