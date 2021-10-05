package com.vinicius.pokeapp.service.util

import com.squareup.moshi.Moshi
import com.vinicius.pokeapp.service.response.ErrorResponse
import com.vinicius.pokeapp.service.response.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.Error.GenericError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ResultWrapper.Error.NetworkError(code, errorResponse)
                }
                else -> {
                    ResultWrapper.Error.GenericError
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}