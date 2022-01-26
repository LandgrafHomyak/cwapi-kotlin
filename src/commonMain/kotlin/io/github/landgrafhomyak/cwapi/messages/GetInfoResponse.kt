package io.github.landgrafhomyak.cwapi.messages

class GetInfoResponse(
   var balance: kotlin.Long,
) : io.github.landgrafhomyak.cwapi.messages.Message.Server2Client {
    override fun dump() = ""
}
