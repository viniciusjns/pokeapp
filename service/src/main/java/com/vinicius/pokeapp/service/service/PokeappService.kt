package com.vinicius.pokeapp.service.service

import com.vinicius.pokeapp.service.response.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeappService {

    @GET("pokemon/{id}")
    suspend fun fetchPokemonById(
        @Path("id") id: Int = 1
    ): Pokemon

    @GET("https://pokemon-db-json.herokuapp.com/")
    suspend fun fetchPokemons(): List<Pokemon>

}