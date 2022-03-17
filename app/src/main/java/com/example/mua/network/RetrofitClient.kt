package com.example.mua.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        var gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        var client: Retrofit? = null
        fun getClient(baseURL: String): Retrofit? {
            if (client == null) {
                client = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return client
        }
    }
}