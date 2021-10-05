package com.vinicius.pokeapp.service.service

import com.vinicius.pokeapp.service.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeappService {

    @GET("https://pokemon-db-json.herokuapp.com/")
    suspend fun fetchPokemons(): List<PokemonResponse>

}