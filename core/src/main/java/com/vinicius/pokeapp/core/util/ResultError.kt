package com.vinicius.pokeapp.core.util

sealed class ResultError {
	data class NetworkError(val code: Int? = null, val message: String = "") : ResultError()
	object GenericError : ResultError()
}