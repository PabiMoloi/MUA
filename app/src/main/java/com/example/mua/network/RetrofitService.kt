package com.example.mua.network

import com.example.mua.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("products.json?product_type=")
    suspend fun getProductsByType(@Query("product_type") product_type: String): Response<List<Product>>

    @GET("products.json?brand=")
    suspend fun getProductsByBrand(@Query("brand") brand: String): Response<List<Product>>
}