package io.github.landgrafhomyak.cwapi.messages

class WantToBuyRequest(
   var quantity: kotlin.ULong,
   var price: kotlin.ULong,
   var itemCode: io.github.landgrafhomyak.cwapi.types.ItemCode,
   var exactPrice: kotlin.Boolean,
   var token: io.github.landgrafhomyak.cwapi.types.Token,
) : io.github.landgrafhomyak.cwapi.messages.Message.Client2Server {
    override fun dump() = ""
}
