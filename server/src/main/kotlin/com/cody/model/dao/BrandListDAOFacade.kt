package com.cody.model.dao

import com.cody.model.entity.Brand

interface BrandListDAOFacade {

    suspend fun putBrand(
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
    ): Brand

    suspend fun getBrandList(): List<Brand>

    suspend fun getExam1List(): List<Brand>
    suspend fun getExam2List(): List<Brand>
    suspend fun getExam3List(catNo: Int): List<Brand>

    suspend fun delBrand(id: Int): Boolean
}
