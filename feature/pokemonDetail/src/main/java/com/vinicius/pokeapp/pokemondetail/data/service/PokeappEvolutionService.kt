package com.vinicius.pokeapp.pokemondetail.data.service

import com.vinicius.pokeapp.pokemondetail.data.model.PokemonEvolutionResponse
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonSpecieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeappEvolutionService {

    @GET("https://pokeapi.co/api/v2/pokemon-species/{pokemonId}/")
    suspend fun getPokemonSpecie(
        @Path("pokemonId") pokemonId: Int
    ): PokemonSpecieResponse

    @GET("https://pokeapi.co/api/v2/evolution-chain/{chainId}/")
    suspend fun getPokemonEvolutionChain(
        @Path("chainId") chainId: Int
    ): PokemonEvolutionResponse

}