package io.github.landgrafhomyak.cwapi.messages

class RequestStockRequest(
   var token: io.github.landgrafhomyak.cwapi.types.Token,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
