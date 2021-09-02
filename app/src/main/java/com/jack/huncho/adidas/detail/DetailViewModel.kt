package com.jack.huncho.adidas.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jack.huncho.adidas.product.Product
import com.jack.huncho.adidas.repo.ReviewRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(product: Product, private val repo: ReviewRepo) : ViewModel() {

    private var viewModelJob = Job()
    private var scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    init {
        _product.value = product
        getRequest()

    }

    private fun getRequest() {
        scope.launch {
            val response = repo.getAll()

        }

    }

}