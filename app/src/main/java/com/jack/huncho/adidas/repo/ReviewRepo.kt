package com.jack.huncho.adidas.repo

import com.jack.huncho.adidas.network.ReviewApi
import com.jack.huncho.adidas.network.ReviewApiService

class ReviewRepo(private val api: ReviewApiService) : ReviewApi() {

    suspend fun getAll() = getAllRequest {api.getAll()}
}