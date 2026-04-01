package net.azisaba.exposed

import org.bukkit.inventory.ItemStack
import org.jetbrains.exposed.v1.core.ColumnType
import org.jetbrains.exposed.v1.core.vendors.H2Dialect
import org.jetbrains.exposed.v1.core.vendors.MysqlDialect
import org.jetbrains.exposed.v1.core.vendors.PostgreSQLDialect
import org.jetbrains.exposed.v1.core.vendors.currentDialect
import java.sql.Blob

internal object ItemStackColumnType : ColumnType<ItemStack>() {
    override fun sqlType(): String = when (currentDialect) {
        is PostgreSQLDialect -> "BYTEA"
        is MysqlDialect -> "MEDIUMBLOB"
        is H2Dialect -> "BLOB"
        else -> "BLOB"
    }

    override fun valueFromDB(value: Any): ItemStack? {
        val bytes = when (value) {
            is ByteArray -> value
            is Blob -> value.binaryStream.readAllBytes()
            else -> error("Unexpected value for ItemStack: $value")
        }

        if (bytes.isEmpty()) return null

        return runCatching {
            ItemStack.deserializeBytes(bytes)
        }.getOrNull()
    }

    override fun notNullValueToDB(value: ItemStack): Any {
        return value.serializeAsBytes()
    }
}
