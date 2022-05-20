package com.vinicius.pokeapp.pokemonlist.data.service

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse
import retrofit2.http.GET

interface PokeappService {

    @GET("https://pokemon-db-json.herokuapp.com/")
    suspend fun fetchPokemons(): List<PokemonResponse>

}