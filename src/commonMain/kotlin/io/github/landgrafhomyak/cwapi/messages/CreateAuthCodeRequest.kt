package io.github.landgrafhomyak.cwapi.messages

class CreateAuthCodeRequest(
   var userId: io.github.landgrafhomyak.cwapi.types.TelegramUserId,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
