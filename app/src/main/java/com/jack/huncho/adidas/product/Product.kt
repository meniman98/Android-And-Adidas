package com.jack.huncho.adidas.product

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val currency: String,
    val price: Int,
    val id: String,
    val name: String,
    val description: String,
    val imgUrl: String
) : Parcelable
