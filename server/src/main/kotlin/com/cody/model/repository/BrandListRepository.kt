package com.cody.model.repository

import com.cody.model.dao.BrandListDAOFacade
import com.cody.model.dao.BrandListDAOFacadeImpl
import com.cody.model.entity.Brand

class BrandListRepository {
    private val dao: BrandListDAOFacade = BrandListDAOFacadeImpl()

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
    ): Brand {
        return dao.putBrand(name, total, cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8)
    }

    suspend fun getBrandList(): List<Brand> {
        val listOfWishes = dao.getBrandList()
        if (listOfWishes.isEmpty()) {
            return listOf(Brand(-1, "", -1, -1, -1, -1, -1, -1, -1, -1, -1))
        }
        return dao.getBrandList()
    }

    suspend fun getExam1List(): List<Brand> {
        val listOfWishes = dao.getExam1List()
        if (listOfWishes.isEmpty()) {
            return listOf(Brand(-1, "", -1, -1, -1, -1, -1, -1, -1, -1, -1))
        }
        return dao.getExam1List()
    }

    suspend fun getExam2List(): List<Brand> {
        val listOfWishes = dao.getExam2List()
        if (listOfWishes.isEmpty()) {
            return listOf(Brand(-1, "", -1, -1, -1, -1, -1, -1, -1, -1, -1))
        }
        return dao.getExam2List()
    }

    suspend fun getExam3List(catNo: Int): List<Brand> {
        val listOfWishes = dao.getExam3List(catNo)
        if (listOfWishes.isEmpty()) {
            return listOf(
                    Brand(-1, "", -1, -1, -1, -1, -1, -1, -1, -1, -1),
                    Brand(-1, "", -1, -1, -1, -1, -1, -1, -1, -1, -1)
            )
        }
        return dao.getExam3List(catNo)
    }

    suspend fun delBrand(id: Int): Boolean {
        return dao.delBrand(id)
    }
}
