package io.github.landgrafhomyak.cwapi.messages

class AuthAdditionalOperationRequest(
   var operation: io.github.landgrafhomyak.cwapi.types.Operation,
   var token: io.github.landgrafhomyak.cwapi.types.Token,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
