package com.example.mua.view

sealed class Screens(val route: String) {
    object Home : Screens("HomeScreen")
    object Category : Screens("CategoriesScreen")
    object Brands : Screens("BrandsScreen")
    object ProductCategory : Screens("ProductCategory/{category}")
    object ProductDetail : Screens("ProductDetail/{category}/{product}")
    object BrandSelected : Screens("Brand/{brand}")
}