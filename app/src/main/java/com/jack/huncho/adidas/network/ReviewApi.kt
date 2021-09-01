package com.jack.huncho.adidas.network

import android.util.Log
import retrofit2.Response
import java.net.ConnectException

private const val TAG = "ReviewApi"

abstract class ReviewApi {
    suspend fun <T: Any> getAll(call: suspend () -> Response<T>): T? {
        var response: Response<T>? = null
        try {
            response = call.invoke()
        } catch (e: ConnectException) {
            Log.i(TAG, "getAll: ${e.message}")
        }
        return response?.body()
    }
}