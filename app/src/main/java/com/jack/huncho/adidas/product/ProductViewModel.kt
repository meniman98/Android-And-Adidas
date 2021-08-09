package com.jack.huncho.adidas.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jack.huncho.adidas.network.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _property = MutableLiveData<Product>()
    val property: LiveData<Product>
        get() = _property

    init {
        getRequest()
    }

    private fun getRequest() {
        scope.launch {
            val response = ProductApi.retrofitService.getAllProducts()
            _property.value = response[0]
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}