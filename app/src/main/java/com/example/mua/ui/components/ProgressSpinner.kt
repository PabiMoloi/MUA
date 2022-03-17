package com.example.mua.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressSpinner() {
    CircularProgressIndicator(
        strokeWidth = 4.dp,
        color =
        if (isSystemInDarkTheme()) {
            Color.White
        } else {
            Color.Black
        }
    )
}