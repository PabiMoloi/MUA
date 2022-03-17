package com.example.mua.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
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
import com.example.mua.ui.components.*
import com.example.mua.viewmodel.ProductCategoryViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun ProductCategory(navController: NavController, category: String, categoryViewModel: ProductCategoryViewModel) {
    val productState = categoryViewModel.productCategoryState
    categoryViewModel.getProductsByCategory(category)

    Scaffold(topBar = {
        TopBarWithNav(category.replaceFirstChar { name ->
            if (name.isLowerCase()) name.titlecase(Locale.ENGLISH) else name.toString()
        }, navController)
    }) {
        LoadingView(productState.value) {
            CategoryScreen(
                (productState.value as ProductState.Products).data,
                category, navController
            )
        }
    }

}

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun CategoryScreen(
    products: List<Product>,
    title: String,
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
        LoadProducts(products = products, navController, title)
    }
}

/*@Composable
fun LoadingView(state: ProductState, content: @Composable () -> Unit) =
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
@ExperimentalFoundationApi
@Composable
fun LoadProducts(products: List<Product>, navController: NavController, category: String) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        itemsIndexed(items = products) { index: Int, item: Product ->
            Column(modifier = Modifier.clickable {
                navController.navigate("ProductDetail/${category}/${item.id}")
            }) {
                ProductCard(item)
            }
        }
    }
}