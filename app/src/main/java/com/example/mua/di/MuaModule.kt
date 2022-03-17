package com.example.mua.di

import com.example.mua.network.RetrofitService
import com.example.mua.network.RetrofitUtil
import com.example.mua.repository.ProductRepository
import com.example.mua.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object MuaModule {

    @Provides
    fun provideProductRepository(): ProductRepository {
        return ProductRepositoryImpl(provideRetrofit()!!)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): RetrofitService? {
        return RetrofitUtil.getRetrofitService()
    }
}