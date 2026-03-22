package net.azisaba.exposed

import net.kyori.adventure.key.Key
import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.Table

fun Table.key(name: String, length: Int = 255): Column<Key> = registerColumn(name, KeyColumnType(length))
