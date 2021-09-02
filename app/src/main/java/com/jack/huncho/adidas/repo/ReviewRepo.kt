package com.jack.huncho.adidas.repo

import com.jack.huncho.adidas.network.ReviewApi
import com.jack.huncho.adidas.network.ReviewApiService
import com.jack.huncho.adidas.review.Review
import retrofit2.Response

class ReviewRepo(private val api: ReviewApiService) : ReviewApi() {



    suspend fun getAll() = getAllRequest {
       val response: Response<List<Review>> = api.getAll()
       response
    }
}