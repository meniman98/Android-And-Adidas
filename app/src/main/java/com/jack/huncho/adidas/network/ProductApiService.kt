package com.jack.huncho.adidas.network

import com.jack.huncho.adidas.product.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:3001/"
private const val PRODUCT_ENDPOINT = "product"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
    .create(ProductApiService::class.java)

/** Interface for the network where functions are defined */
interface ProductApiService {

    @GET(PRODUCT_ENDPOINT)
    suspend fun getAllProducts() : Response<List<Product>>

    companion object {
        operator fun invoke(): ProductApiService {
            return retrofit
        }
    }
}