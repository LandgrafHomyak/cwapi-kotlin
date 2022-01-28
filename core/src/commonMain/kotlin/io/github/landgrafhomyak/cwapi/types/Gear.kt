package io.github.landgrafhomyak.cwapi.types

import io.github.landgrafhomyak.cwapi.json.JsonSerializable

class Gear(
    val name: String,
    val atk: ULong,
    val def: ULong,
    val condition: Condition,
    val quality: Quality,
    val mana: ULong
) : JsonSerializable {
    override fun toJson(): String {
        TODO("Not yet implemented")
    }

}