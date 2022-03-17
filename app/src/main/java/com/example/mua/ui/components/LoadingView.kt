package com.example.mua.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mua.model.ProductState

@Composable
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
    }