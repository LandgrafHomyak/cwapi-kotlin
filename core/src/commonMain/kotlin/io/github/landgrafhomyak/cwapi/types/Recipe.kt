package io.github.landgrafhomyak.cwapi.types

import io.github.landgrafhomyak.cwapi.json.JsonSerializable
import io.github.landgrafhomyak.cwapi.json.toJson

class Recipe(
    val id: ItemCode,
    val name: String,
    val price: ULong
) : JsonSerializable {
    override fun toJson(): String = """{"id":${this.id.toJson()},"name":${this.name.toJson()},"price":${this.price.toJson()}}"""
}