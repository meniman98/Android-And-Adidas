package com.jack.huncho.adidas.product

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.jack.huncho.adidas.repo.ProductRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: ProductRepo) : ViewModel() {

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _property = MutableLiveData<List<Product>>()
    val property: LiveData<List<Product>>
        get() = _property

    private var _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status


    init {
        getRequest()
    }

    private fun getRequest() {
        scope.launch {
            val response = repo.getAllProducts()
            when {
                response.isNullOrEmpty() ->
                    _status.value = "List couldn't be retrieved. Likely caused" +
                            " due to a faulty connection or empty list"
                else -> {
                    _status.value = "Connection was successful and " +
                            "${response.size} item(s) retrieved"
                    _property.value = response!!
                }


            }
        }
    }

    /** Show a Snackbar */
    fun onSnack(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}