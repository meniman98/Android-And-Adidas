package com.jack.huncho.adidas.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jack.huncho.adidas.product.Product

class DetailViewModel(product: Product) : ViewModel() {

    private var _product = MutableLiveData<Product>()
    val product: LiveData<Product>
    get() = _product

    init {
        _product.value = product
    }

}