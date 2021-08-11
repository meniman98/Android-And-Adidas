package com.jack.huncho.adidas.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jack.huncho.adidas.repo.ProductRepo

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(private val repo: ProductRepo)
    : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(repo) as T
    }
}