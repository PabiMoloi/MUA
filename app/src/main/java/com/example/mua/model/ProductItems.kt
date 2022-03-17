package com.example.mua.model

sealed class ProductItems {
    data class ProductListHeader(val title: String) : ProductItems()
    data class ProductList(val product: Product): ProductItems()
}