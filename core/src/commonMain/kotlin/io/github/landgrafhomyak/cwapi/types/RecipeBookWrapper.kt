package io.github.landgrafhomyak.cwapi.types

import kotlin.jvm.JvmInline

@JvmInline
value class RecipeBookWrapper(private val map: MutableMap<ItemCode, Recipe>) : RecipeBook {
    override val entries: MutableSet<MutableMap.MutableEntry<ItemCode, Recipe>>
        get() = this.map.entries
    override val keys: MutableSet<ItemCode>
        get() = this.map.keys
    override val size: Int
        get() = this.map.size
    override val values: MutableCollection<Recipe>
        get() = this.map.values

    override fun clear() = this.map.clear()

    override fun containsKey(key: ItemCode) = this.map.containsKey(key)

    override fun containsValue(value: Recipe) = this.map.containsValue(value)

    override operator fun get(key: ItemCode) = this.map.get(key)

    override fun isEmpty() = this.map.isEmpty()

    override fun put(key: ItemCode, value: Recipe) = this.map.put(key, value)

    override fun putAll(from: Map<out ItemCode, Recipe>) = this.map.putAll(from)

    override fun remove(key: ItemCode) = this.map.remove(key)
}