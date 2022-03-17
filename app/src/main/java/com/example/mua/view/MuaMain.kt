package com.example.mua.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mua.viewmodel.ProductBrandViewModel
import com.example.mua.viewmodel.ProductCategoryViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalPagerApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MuaMain() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(Screens.Home.route) { HomeScreen(navController) }
        composable(Screens.Category.route) { CategoriesScreen(navController) }
        composable(Screens.Brands.route) { BrandsScreen(navController) }
        composable(Screens.ProductCategory.route) { backStackEntry ->
            val viewModel = hiltViewModel<ProductCategoryViewModel>()
            ProductCategory(
                navController,
                backStackEntry.arguments?.getString(
                    "category"
                ) ?: "foundation", viewModel
            )
        }
        composable(
            Screens.ProductDetail.route,
            arguments = listOf(navArgument("category") { type = NavType.StringType },
                navArgument("product") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<ProductCategoryViewModel>()
            val category = navBackStackEntry.arguments?.getString("category")!!
            val index = navBackStackEntry.arguments?.getInt("product")!!
            ProductDetail(category, index, navController, viewModel)
        }
        composable(
            Screens.BrandSelected.route,
            arguments = listOf(navArgument("brand") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<ProductBrandViewModel>()
            val brandSelected = navBackStackEntry.arguments?.getString("brand")!!
            Brand(navController = navController, brand = brandSelected, viewModel = viewModel)
        }
    }
}