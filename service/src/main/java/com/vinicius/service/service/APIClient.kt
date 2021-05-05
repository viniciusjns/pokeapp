package com.vinicius.core.service

import retrofit2.Retrofit

interface APIClient {
    fun configure(baseUrl: String): Retrofit
}