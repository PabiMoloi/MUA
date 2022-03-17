package com.example.mua.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mua.model.ProductState
import com.example.mua.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ProductBrandViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {
    var productBrandState = mutableStateOf<ProductState>(ProductState.LoadingState)
        private set

    fun getProductsByBrand(brand: String) = viewModelScope.launch {
        try {
            val response = repository.getProductsByBrand(brand)
            if (response.isSuccessful) {
                productBrandState.value = response.body()?.let { ProductState.Products(it) }!!
            } else {
                productBrandState.value = ProductState.Error
            }
        } catch (exception: Exception) {
            productBrandState.value = ProductState.Error
        }
    }
}