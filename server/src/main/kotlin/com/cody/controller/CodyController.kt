package com.cody.controller

import com.cody.model.entity.Brand
import com.cody.model.repository.BrandListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CodyController {
    private val brandListRepository = BrandListRepository()

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
    ): Brand =
            withContext(Dispatchers.IO) {
                brandListRepository.putBrand(
                        name,
                        total,
                        cat1,
                        cat2,
                        cat3,
                        cat4,
                        cat5,
                        cat6,
                        cat7,
                        cat8
                )
            }

    suspend fun getBrandList(): List<Brand> = run { brandListRepository.getBrandList() }

    suspend fun getExam1List(): List<Brand> = run { brandListRepository.getExam1List() }
    suspend fun getExam2List(): List<Brand> = run { brandListRepository.getExam2List() }
    suspend fun getExam3List(catNo: Int): List<Brand> = run {
        brandListRepository.getExam3List(catNo)
    }

    suspend fun delBrand(id: Int): Boolean = run { brandListRepository.delBrand(id) }
}
