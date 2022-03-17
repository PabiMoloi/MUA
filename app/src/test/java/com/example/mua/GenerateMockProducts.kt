package com.example.mua

import com.example.mua.model.Product

fun mockProducts(): List<Product> {
    val productList = mutableListOf<Product>()
    val productA =
        Product(
            1,
            "CoverGirl",
            "Glitter Lipstick",
            "0.0",
            "$",
            "image link",
            "product link",
            "www.google.com",
            "www.google.com",
            "This glitter lipstick will make your lips shine!",
            1.5,
            "lipstick",
            "lipstick",
            null,
            null
        )
    val productB =
        Product(
            2,
            "CoverGirl",
            "Glitter Lipstick",
            "0.0",
            "$",
            "image link",
            "product link",
            "www.google.com",
            "www.google.com",
            "This glitter lipstick will make your lips shine!",
            1.5,
            "lipstick",
            "lipstick",
            null,
            null
        )
    productList.add(productA)
    productList.add(productB)
    return productList
}