package com.jack.huncho.adidas.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jack.huncho.adidas.product.Product
import com.jack.huncho.adidas.repo.ReviewRepo
import com.jack.huncho.adidas.review.Review
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DetailViewModel(product: Product, private val repo: ReviewRepo) : ViewModel() {

    private val TAG = "DetailViewModel"

    private var viewModelJob = Job()
    private var scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    private var _property = MutableLiveData<List<Review>>()
    val property: LiveData<List<Review>>
        get() = _property

    init {
        _product.value = product
        getRequest()
    }

    @SuppressLint("NullSafeMutableLiveData")
    private fun getRequest() {
        scope.launch {
            val response = repo.getAll()
            when {
                response.isNullOrEmpty() ->
                    Log.i(TAG, "getRequest: ")
                else -> {
                    _property.value = response
                }


            }

        }

    }

}