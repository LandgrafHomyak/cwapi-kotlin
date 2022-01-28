package io.github.landgrafhomyak.cwapi.types

import io.github.landgrafhomyak.cwapi.json.JsonSerializable

interface RecipeBook : MutableMap<ItemCode, Recipe>, JsonSerializable {
    override fun toJson() = "[${this.values.joinToString(",", transform = Recipe::toJson)}]"
}