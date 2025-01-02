package com.cody.model.dao

import com.cody.exceptions.DbElementInsertException
import com.cody.model.DatabaseSingleton.dbQuery
import com.cody.model.entity.Brand
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class BrandListDAOFacadeImpl : BrandListDAOFacade {

    private fun resultRowToBrand(row: ResultRow) =
            Brand(
                    id = row[BrandTable.id],
                    name = row[BrandTable.name],
                    total = row[BrandTable.total],
                    cat1 = row[BrandTable.cat1],
                    cat2 = row[BrandTable.cat2],
                    cat3 = row[BrandTable.cat3],
                    cat4 = row[BrandTable.cat4],
                    cat5 = row[BrandTable.cat5],
                    cat6 = row[BrandTable.cat6],
                    cat7 = row[BrandTable.cat7],
                    cat8 = row[BrandTable.cat8]
            )

    override suspend fun putBrand(
            name: String,
            total: Int,
            cat1: Int,
            cat2: Int,
            cat3: Int,
            cat4: Int,
            cat5: Int,
            cat6: Int,
            cat7: Int,
            cat8: Int
    ): Brand = dbQuery {
        val insertStatement =
                BrandTable.insert {
                    it[BrandTable.name] = name
                    it[BrandTable.total] = total
                    it[BrandTable.cat1] = cat1
                    it[BrandTable.cat2] = cat2
                    it[BrandTable.cat3] = cat3
                    it[BrandTable.cat4] = cat4
                    it[BrandTable.cat5] = cat5
                    it[BrandTable.cat6] = cat6
                    it[BrandTable.cat7] = cat7
                    it[BrandTable.cat8] = cat8
                }

        val resultMap = insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToBrand)

        if (resultMap == null) {
            throw DbElementInsertException("You've exceeded your wish limit")
        } else {
            return@dbQuery resultMap
        }
    }

    override suspend fun getBrandList(): List<Brand> = dbQuery {
        BrandTable.selectAll().map(::resultRowToBrand)
    }

    override suspend fun getExam1List(): List<Brand> = dbQuery {

        // TODO h2 unionAll() 에 서브쿼리 지원유무 확인

        BrandTable.selectAll()
                .orderBy(BrandTable.cat1 to SortOrder.ASC)
                .limit(1)
                .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat2 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat3 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat4 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat5 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat6 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat7 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat8 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand)
    }

    override suspend fun getExam2List(): List<Brand> = dbQuery {
        BrandTable.selectAll()
                .orderBy(BrandTable.total to SortOrder.ASC)
                .limit(1)
                .map(::resultRowToBrand)
    }

    override suspend fun getExam3List(catNo: Int): List<Brand> = dbQuery {
        when (catNo) {
            1 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat1 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat1 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            2 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat2 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat2 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            3 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat3 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat3 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            4 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat4 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat4 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            5 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat5 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat5 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            6 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat6 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat6 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            7 -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat7 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat7 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
            // 8 -> {
            //     BrandTable.selectAll()
            //             .orderBy(BrandTable.cat8 to SortOrder.ASC)
            //             .limit(1)
            //             .map(::resultRowToBrand) +
            //             BrandTable.selectAll()
            //                     .orderBy(BrandTable.cat8 to SortOrder.DESC)
            //                     .limit(1)
            //                     .map(::resultRowToBrand)
            // }
            else -> {
                BrandTable.selectAll()
                        .orderBy(BrandTable.cat8 to SortOrder.ASC)
                        .limit(1)
                        .map(::resultRowToBrand) +
                        BrandTable.selectAll()
                                .orderBy(BrandTable.cat8 to SortOrder.DESC)
                                .limit(1)
                                .map(::resultRowToBrand)
            }
        }
    }

    override suspend fun delBrand(id: Int): Boolean = dbQuery {
        BrandTable.deleteWhere { BrandTable.id eq id } > 0
    }
}
