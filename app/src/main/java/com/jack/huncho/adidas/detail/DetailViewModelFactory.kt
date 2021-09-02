package com.jack.huncho.adidas.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jack.huncho.adidas.product.Product
import com.jack.huncho.adidas.repo.ReviewRepo

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val product: Product, private val repo: ReviewRepo)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(product, repo) as T
    }


}