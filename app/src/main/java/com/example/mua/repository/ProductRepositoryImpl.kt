package com.example.mua.repository

import com.example.mua.model.Product
import com.example.mua.network.RetrofitService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(private val retrofitService: RetrofitService) :
    ProductRepository {

    override suspend fun getProductsByType(productType: String): Response<List<Product>> {
        return retrofitService.getProductsByType(productType)
    }

    override suspend fun getProductsByBrand(brand: String): Response<List<Product>> {
        return retrofitService.getProductsByBrand(brand)
    }
}