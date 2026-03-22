package net.azisaba.exposed

import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.kyori.adventure.text.serializer.json.JSONComponentSerializer
import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.Table

fun Table.component(
    name: String,
    serializer: JSONComponentSerializer = GsonComponentSerializer.gson(),
): Column<Component> = registerColumn(name, ComponentColumnType(serializer))

fun Table.key(name: String, length: Int = 255): Column<Key> = registerColumn(name, KeyColumnType(length))

fun Table.textColor(name: String): Column<TextColor> = registerColumn(name, TextColorColumnType)
