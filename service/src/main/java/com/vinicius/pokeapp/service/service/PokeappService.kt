package com.vinicius.pokeapp.service.service

import com.vinicius.pokeapp.service.response.PokemonList
import com.vinicius.pokeapp.service.response.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeappService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonList

    @GET("pokemon/{id}")
    suspend fun fetchPokemonById(
        @Path("id") id: Int = 1
    ): Pokemon

}