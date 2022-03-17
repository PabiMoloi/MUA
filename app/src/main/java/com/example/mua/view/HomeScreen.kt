package com.example.mua.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mua.ui.components.TabItem
import com.example.mua.ui.components.Tabs
import com.example.mua.ui.components.TabsContent
import com.example.mua.ui.components.TopBar
import com.example.mua.ui.theme.MUATheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalCoroutinesApi
@Composable
fun HomeScreen(navController: NavController) {
    val tabs = listOf(TabItem.Categories, TabItem.Brands)
    val pagerState = rememberPagerState()

    Scaffold(topBar = { TopBar("MUA") }) {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState, navController)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalCoroutinesApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MUATheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}