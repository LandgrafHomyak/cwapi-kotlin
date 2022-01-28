package io.github.landgrafhomyak.cwapi.messages

import io.github.landgrafhomyak.cwapi.json.toJson
import io.github.landgrafhomyak.cwapi.types.RecipeBook
import io.github.landgrafhomyak.cwapi.types.TelegramUserId


class ViewCraftbookResponse(
    val userId: TelegramUserId,
    val craft: RecipeBook?,
    val alchemy: RecipeBook?,
) : Message.Server2Client {
    override fun toJson(): String {
        val alchemy = this.alchemy
        val craft = this.craft
        return """{"action":"viewCraftbook","result":"Ok","userId":${this.userId.toJson()},"payload":{${
            if (alchemy != null) """"alchemy":${alchemy.toJson()}"""
            else ""
        }${
            if ((alchemy != null) and (craft != null)) ","
            else ""
        }${
            if (craft != null) """"craft":${craft.toJson()}"""
            else ""
        }}}"""
    }
}
