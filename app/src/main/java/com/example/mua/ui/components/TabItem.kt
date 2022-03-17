package com.example.mua.ui.components

import androidx.compose.material.ExperimentalMaterialApi
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@ExperimentalPagerApi
sealed class TabItem(var title: String) {
    object Categories: TabItem("Category")
    object Brands : TabItem("Brands")
}
