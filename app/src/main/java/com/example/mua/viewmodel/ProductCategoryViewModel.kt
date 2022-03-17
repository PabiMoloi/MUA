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
class ProductCategoryViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {

    var productCategoryState = mutableStateOf<ProductState>(ProductState.LoadingState)
        private set

    fun getProductsByCategory(productType: String) = viewModelScope.launch {
        try {
            val response = repository.getProductsByType(productType)
            if (response.isSuccessful) {
                productCategoryState.value = response.body()?.let { ProductState.Products(it) }!!
            } else {
                productCategoryState.value = ProductState.Error
            }
        } catch (exception: Exception) {
            productCategoryState.value = ProductState.Error
        }

    }
}
