package com.example.mua.repository

import com.example.mua.model.Product
import retrofit2.Response

interface ProductRepository {
    suspend fun getProductsByType(productType: String): Response<List<Product>>
    suspend fun getProductsByBrand(brand: String): Response<List<Product>>
}