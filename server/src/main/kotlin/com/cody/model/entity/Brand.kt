package com.cody.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class Brand(
        val id: Int,
        val name: String,
        val total: Int,
        val cat1: Int,
        val cat2: Int,
        val cat3: Int,
        val cat4: Int,
        val cat5: Int,
        val cat6: Int,
        val cat7: Int,
        val cat8: Int
)
