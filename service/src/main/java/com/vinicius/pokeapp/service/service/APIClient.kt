package com.vinicius.pokeapp.service.service

import retrofit2.Retrofit

interface APIClient {
    fun configure(baseUrl: String): Retrofit
}