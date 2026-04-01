package net.azisaba.exposed

import org.bukkit.inventory.ItemStack
import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.Table

fun Table.itemStack(name: String): Column<ItemStack> = registerColumn(name, ItemStackColumnType)
