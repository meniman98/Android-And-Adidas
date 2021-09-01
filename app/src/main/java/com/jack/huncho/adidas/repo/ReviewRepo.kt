package com.jack.huncho.adidas.repo

import com.jack.huncho.adidas.network.ReviewApi
import com.jack.huncho.adidas.network.ReviewApiService
import com.jack.huncho.adidas.review.Review

class ReviewRepo(private val api: ReviewApiService) {

    suspend fun getAll(): List<Review> {
        return api.getAll()
    }
}