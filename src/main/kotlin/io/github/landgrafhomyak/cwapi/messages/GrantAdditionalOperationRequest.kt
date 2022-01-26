package io.github.landgrafhomyak.cwapi.messages

class GrantAdditionalOperationRequest(
   var authCode: io.github.landgrafhomyak.cwapi.types.AuthCode,
   var requestId: io.github.landgrafhomyak.cwapi.types.RequestId,
   var token: io.github.landgrafhomyak.cwapi.types.Token,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
