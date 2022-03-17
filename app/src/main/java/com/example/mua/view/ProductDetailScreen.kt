package com.example.mua.view

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mua.model.Product
import com.example.mua.model.ProductState
import com.example.mua.ui.components.ErrorMessage
import com.example.mua.ui.components.ProgressSpinner
import com.example.mua.ui.components.TopBarWithNav
import com.example.mua.viewmodel.ProductCategoryViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun ProductDetail(
    category: String,
    productId: Int,
    navController: NavController,
    categoryViewModel: ProductCategoryViewModel
) {
    val productState = categoryViewModel.productCategoryState
    categoryViewModel.getProductsByCategory(category)
    var selectedProduct: Product? = null
    Loader(state = productState.value) {
        val productList = (productState.value as ProductState.Products).data
        for (product in productList) {
            selectedProduct = if (product.id == productId) product else continue
            break
        }
        selectedProduct?.let { ProductDetails(it, selectedProduct?.name.toString(), navController) }
    }
}

@Composable
fun ProductDetails(product: Product, title: String, navController: NavController) {
    Scaffold(topBar = {
        TopBarWithNav(title, navController)
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .scrollable(orientation = Orientation.Vertical, state = rememberScrollState())
        ) {
            com.example.mua.ui.components.ProductDetail(product)
        }
    }
}

@Composable
fun Loader(state: ProductState, content: @Composable () -> Unit) =
    when (state) {
        ProductState.LoadingState -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ProgressSpinner()
            }
        }
        ProductState.Error -> {
            ErrorMessage()
        }
        else -> {
            content()
        }
    }
