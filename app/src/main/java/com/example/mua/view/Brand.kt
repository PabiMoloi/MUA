package com.example.mua.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mua.R
import com.example.mua.model.Product
import com.example.mua.model.ProductState
import com.example.mua.ui.components.LoadingView
import com.example.mua.ui.components.ProductCard
import com.example.mua.ui.components.TopBarWithNav
import com.example.mua.viewmodel.ProductBrandViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@ExperimentalPagerApi
@Composable
fun Brand(navController: NavController, brand: String, viewModel: ProductBrandViewModel) {
    val productState = viewModel.productBrandState
    viewModel.getProductsByBrand(brand)

    Scaffold(topBar = {
        TopBarWithNav(brand.replaceFirstChar { name ->
            if (name.isLowerCase()) name.titlecase(Locale.ENGLISH) else name.toString()
        }, navController)
    }) {
        LoadingView(state = productState.value) {
            BrandProducts((productState.value as ProductState.Products).data, navController)
        }
    }
}

/*@Composable
fun BrandingLoadingView(state: ProductState, content: @Composable () -> Unit) =
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
    }*/

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun BrandProducts(
    products: List<Product>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (!isSystemInDarkTheme()) colorResource(id = R.color.light_grey) else Color.Black)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${products.count()} items",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        BrandProductsGrid(products, navController)
    }

}

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun BrandProductsGrid(products: List<Product>, navController: NavController) {
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 135.dp)) {
        itemsIndexed(items = products) { index: Int, item: Product ->
            Column(modifier = Modifier.clickable {
                navController.navigate("ProductDetail/${item.product_type}/${item.id}")
            }) {
                ProductCard(item)
            }
        }
    }
}