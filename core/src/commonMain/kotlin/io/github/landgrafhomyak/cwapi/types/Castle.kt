package io.github.landgrafhomyak.cwapi.types

import io.github.landgrafhomyak.cwapi.json.JsonSerializable

sealed interface Castle : JsonSerializable {
    enum class CW3 : Castle
    enum class CW2 : Castle
}