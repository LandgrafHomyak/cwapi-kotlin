package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.ItemCode
import io.github.landgrafhomyak.cwapi.types.Token

class WantToBuyRequest(
    val token: Token,
    val itemCode: ItemCode,
    val quantity: ULong,
    val price: ULong,
    val exactPrice: Boolean,
) : Message.Client2Server {
    override fun toJson() = """{"token":${this.token.toJson()},"action":"wantToBuy","payload":{"itemCode":${this.itemCode.toJson()},"quantity":${this.quantity.toJson()},"price":${this.price.toJson()},"exactPrice":${this.exactPrice.toJson()}}}}"""
}
