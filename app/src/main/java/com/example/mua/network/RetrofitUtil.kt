package com.example.mua.network

class RetrofitUtil {
    companion object {
        private const val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"
        fun getRetrofitService(): RetrofitService? {
            return RetrofitClient.getClient(BASE_URL)?.create(RetrofitService::class.java)
        }
    }
}