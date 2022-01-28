package io.github.landgrafhomyak.cwapi.json

class UnexpectedCharRangeException(val char: Char) : RuntimeException("Char with unexpected code 0x${char.code.toString(16)}")

fun encodeString(s: String): String {
    val builder = StringBuilder(s.length * 10 + 2)
    builder.append("\"")
    for (c in s) {
        builder.append(
            when (c.code) {
                in 0..0xff -> "\\x${c.code.toString(16).padStart(2, '0')}"
                in 0x100..0xffff -> "\\u${c.code.toString(16).padStart(4, '0')}"
                in 0x10000..0xffffffff -> "\\U${c.code.toString(16).padStart(8, '0')}"
                else -> throw UnexpectedCharRangeException(c)
            }
        )
    }
    builder.append("\"")
    return builder.toString()
}

//fun Any.toJson(): String = throw NotImplementedError("resolve receiver type to convert object to JSON value")

fun String.toJson(): String = encodeString(this)

//fun Token.toJson(): String = encodeString(this)

fun ULong.toJson(): String = this.toString()

fun Long.toJson(): String = this.toString()

//fun TelegramUserId.toJson(): String = this.toString()

fun Boolean.toJson(): String = this.toString()

interface JsonSerializable {
    fun toJson(): String
}
