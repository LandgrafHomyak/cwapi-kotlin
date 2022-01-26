package io.github.landgrafhomyak.cwapi.messages

class GrantTokenRequest(
   var authCode: io.github.landgrafhomyak.cwapi.types.AuthCode,
   var userId: io.github.landgrafhomyak.cwapi.types.TelegramUserId,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
