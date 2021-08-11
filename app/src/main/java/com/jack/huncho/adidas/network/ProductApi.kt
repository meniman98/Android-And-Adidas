package com.jack.huncho.adidas.network

import android.util.Log
import retrofit2.Response
import java.net.ConnectException

private const val TAG = "ProductApi"

/** Class where all network calls are implemented */
abstract class ProductApi {

    /** Performs the get request for all products */
    suspend fun <T : Any> getAllRequest(call: suspend () -> Response<T>): T? {
        var response: Response<T>? = null
        try {
            response = call.invoke()
        } catch (e: ConnectException) {
            Log.i(TAG, "getAllRequest: ${e.message}")
        }
        return response?.body()


//        else {
//            throw Exception(response.code().toString())
//        }
    }

}