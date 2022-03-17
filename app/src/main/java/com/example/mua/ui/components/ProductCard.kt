package com.example.mua.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mua.R
import com.example.mua.model.Product
import com.skydoves.landscapist.coil.CoilImage
import java.util.*

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(8.dp)
            .background(if (!isSystemInDarkTheme()) Color.White else Color.DarkGray)
    ) {
        CoilImage(
            imageModel = product.image_link,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .align(CenterHorizontally),
            placeHolder = painterResource(id = R.drawable.ic_outline_camera),
            error = painterResource(id = R.drawable.ic_outline_camera)
        )
        Divider(
            thickness = 1.dp,
            color = colorResource(id = R.color.light_grey)
        )
        Text(
            product.name.toString(),
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            product.brand.toString().replaceFirstChar { name ->
                if (name.isLowerCase()) name.titlecase(Locale.ENGLISH) else name.toString()
            },
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            fontStyle = FontStyle.Italic
        )
        Text(
            "Category: " + (product.category ?: "None"),
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
        )
    }
}
