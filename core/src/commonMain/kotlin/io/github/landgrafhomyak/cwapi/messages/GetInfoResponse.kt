package io.github.landgrafhomyak.cwapi.messages

class GetInfoResponse(
    val balance: Long,
) : Message.Server2Client {
    override fun toJson() = TODO("Not implemented")
}
