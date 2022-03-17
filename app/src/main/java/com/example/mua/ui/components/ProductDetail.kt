package com.example.mua.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mua.R
import com.example.mua.model.Product
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ProductDetail(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CoilImage(
            imageModel = product.image_link,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(325.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            placeHolder = painterResource(id = R.drawable.ic_outline_camera),
            error = painterResource(id = R.drawable.ic_outline_camera)
        )
    }
    Column(Modifier.padding(8.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = product.name.toString(), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "By " + product.brand.toString(),
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(text = (product.price_sign ?: "$").toString(), fontWeight = FontWeight.Bold)
            Text(text = product.price ?: "0.0", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Divider(
            thickness = 1.dp,
            color = colorResource(id = R.color.light_grey)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Product Description", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.description ?: "Nothing to see here.",
            textAlign = TextAlign.Justify,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Category", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = product.category ?: "None", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Rating", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = product.rating.toString(), fontSize = 12.sp)
    }
}