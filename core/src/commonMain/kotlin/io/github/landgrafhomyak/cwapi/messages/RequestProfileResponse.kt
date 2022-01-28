package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.JsonSerializable
import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.*

class RequestProfileResponse(
    val userId: TelegramUserId,
    val `class`: Class,
    val atk: ULong,
    val def: ULong,
    val castle: Castle,
    val secondaryClass: SecondaryClass?,
    val hp: ULong,
    val maxHp: ULong,
    val exp: Long,
    val gold: Long,
    val guild: Guild?,
    val lvl: ULong,
    val status: Status,
    val action: Action,
    val mana: ULong,
    val pouches: ULong,
    val stamina: ULong,
    val userName: String
) : Message.Server2Client {

    class SecondaryClass(
        val `class`: Class,
        val lvl: ULong
    ) : JsonSerializable {
        override fun toJson() = """{"class":${this.`class`.toJson()},"lvl":${this.lvl.toJson()}}"""
    }

    class Guild(
        val name: String,
        val tag: String?,
        val emoji: String?
    ) : JsonSerializable {
        override fun toJson(): String {
            val tag = this.tag
            val emoji = this.emoji
            return """{${
                if (tag != null) """"tag":${tag.toJson()},"""
                else ""
            }${
                if (emoji != null) """"emoji":${emoji.toJson()},"""
                else ""
            }"name":${this.name.toJson()}}"""
        }
    }

    override fun toJson() = TODO("Not implemented")
}