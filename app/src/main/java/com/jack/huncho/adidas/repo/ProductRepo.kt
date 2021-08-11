package com.jack.huncho.adidas.repo

import com.jack.huncho.adidas.network.ProductApi
import com.jack.huncho.adidas.network.ProductApiService

/** Repo class which retrieves data from the API */
class ProductRepo(private val api: ProductApiService) : ProductApi() {

    /** Function which returns products */
    suspend fun getAllProducts() = getAllRequest { api.getAllProducts() }
}