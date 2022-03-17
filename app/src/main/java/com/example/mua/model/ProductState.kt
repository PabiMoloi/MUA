package com.example.mua.model

sealed class ProductState {
    object LoadingState : ProductState()
    object Error: ProductState()
    data class Products(val data: List<Product>) : ProductState()
}