package io.github.landgrafhomyak.cwapi.types

import io.github.landgrafhomyak.cwapi.json.JsonSerializable

enum class Operation : JsonSerializable {
    GetBasicInfo {
        override fun toJson() = "\"GetBasicInfo\""
    },
    GetUserProfile {
        override fun toJson() = "\"GetUserProfile\""
    },
    ViewCraftbook {
        override fun toJson() = "\"ViewCraftbook\""
    },
    GetGearInfo {
        override fun toJson() = "\"GetGearInfo\""
    },
    GetStock {
        override fun toJson() = "\"GetStock\""
    },
    GuildInfo {
        override fun toJson() = "\"GuildInfo\""
    },
    TradeTerminal {
        override fun toJson() = "\"TradeTerminal\""
    }
}