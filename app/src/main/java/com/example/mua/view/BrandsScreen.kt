package com.example.mua.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mua.ui.components.BrandCard
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun BrandsScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BrandCard(navController, "Brand/maybelline", "Maybelline")
        }
        item {
            BrandCard(navController, "Brand/glossier", "Glossier")
        }
        item {
            BrandCard(navController, "Brand/benefit", "Benefit")
        }
        item {
            BrandCard(navController, "Brand/nyx", "NYX")
        }
        item {
            BrandCard(navController, "Brand/stila", "Stila")
        }
        item {
            BrandCard(navController, "Brand/colourpop", "Colourpop")
        }
    }
}