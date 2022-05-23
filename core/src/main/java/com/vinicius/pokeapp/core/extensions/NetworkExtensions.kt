package com.vinicius.pokeapp.core.extensions

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): Result<T, ResultError> {
    return withContext(dispatcher) {
        try {
            mapResponse(apiCall())
        } catch (exception: Exception) {
            if (exception is HttpException) {
                Result.Error(
                    ResultError.NetworkError(
                        code = exception.response()?.code(),
                        message = exception.message()
                    )
                )
            } else
                Result.Error(ResultError.GenericError)
        }
    }
}

private fun <T> mapResponse(response: T): Result<T, ResultError> {
    return if (response !is Response<*>) {
        Result.Success(response)
    } else {
        if (response.isSuccessful) {
            Result.Success(response)
        } else {
            Result.Error(
                ResultError.NetworkError(code = response.code(), message = response.message())
            )
        }
    }
}