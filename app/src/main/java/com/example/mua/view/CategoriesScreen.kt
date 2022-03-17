package com.example.mua.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mua.ui.components.CategoryCard
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun CategoriesScreen(navController: NavController) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            CategoryCard(navController, "ProductCategory/blush", "Blush")
        }
        item {
            CategoryCard(navController, "ProductCategory/bronzer", "Bronzer")
        }
        item {
            CategoryCard(navController, "ProductCategory/eyebrow", "Eyebrow")
        }
        item {
            CategoryCard(navController, "ProductCategory/eyeliner", "Eyeliner")
        }
        item {
            CategoryCard(navController, "ProductCategory/eyeshadow", "Eyeshadow")
        }
        item {
            CategoryCard(navController, "ProductCategory/foundation", "Foundation")
        }
        item {
            CategoryCard(navController, "ProductCategory/lip_liner", "Lipliner")
        }
        item {
            CategoryCard(navController, "ProductCategory/lipstick", "Lipstick")
        }
        item {
            CategoryCard(navController, "ProductCategory/mascara", "Mascara")
        }
        item {
            CategoryCard(navController, "ProductCategory/nail_polish", "Nail Polish")
        }
    }
}