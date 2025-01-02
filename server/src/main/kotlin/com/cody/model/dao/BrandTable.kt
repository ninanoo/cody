package com.cody.model.dao

import org.jetbrains.exposed.sql.Table

object BrandTable : Table("brand") {

    val id = integer("id").autoIncrement()
    val name = varchar("name", 1024)

    val total = integer("total").index()

    val cat1 = integer("cat1").index()
    val cat2 = integer("cat2").index()
    val cat3 = integer("cat3").index()
    val cat4 = integer("cat4").index()
    val cat5 = integer("cat5").index()
    val cat6 = integer("cat6").index()
    val cat7 = integer("cat7").index()
    val cat8 = integer("cat8").index()

    override val primaryKey = PrimaryKey(id)
}
