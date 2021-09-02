package com.jack.huncho.adidas.network

import com.jack.huncho.adidas.review.Review
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "http://10.0.2.2:8080/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
    .create(ReviewApiService::class.java)

interface ReviewApiService {

    @GET(".")
    suspend fun getAll(): Response<List<Review>>

    companion object {
        operator fun invoke(): ReviewApiService {
            return retrofit
        }
    }

}