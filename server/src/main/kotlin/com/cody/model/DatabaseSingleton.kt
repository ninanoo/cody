package com.cody.model

import com.cody.model.dao.BrandCreateBookTable
import com.cody.model.dao.BrandDeleteBookTable
import com.cody.model.dao.BrandTable
import com.cody.model.dao.BrandUpdateBookTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSingleton {
    fun init(jdbcURL: String, driverClassName: String) {
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            SchemaUtils.create(BrandTable)
            SchemaUtils.create(BrandCreateBookTable)
            SchemaUtils.create(BrandUpdateBookTable)
            SchemaUtils.create(BrandDeleteBookTable)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
            newSuspendedTransaction(Dispatchers.IO) { block() }
}
