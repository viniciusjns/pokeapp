package com.vinicius.pokeapp.service.response

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    sealed class Error: ResultWrapper<Nothing>() {
        data class NetworkError(val code: Int? = null, val error: ErrorResponse? = null) : Error()
        object GenericError : Error()
    }
}