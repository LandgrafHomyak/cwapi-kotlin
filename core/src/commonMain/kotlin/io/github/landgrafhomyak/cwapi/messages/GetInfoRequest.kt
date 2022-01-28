package io.github.landgrafhomyak.cwapi.messages

object GetInfoRequest : Message.Client2Server {
    override fun toJson() = """{"action":"getInfo"}"""
}
