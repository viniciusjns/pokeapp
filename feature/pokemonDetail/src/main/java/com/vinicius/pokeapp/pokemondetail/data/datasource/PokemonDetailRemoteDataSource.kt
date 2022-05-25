package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonEvolutionResponse
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonSpecieResponse

interface PokemonDetailRemoteDataSource {
    suspend fun getPokemonSpecie(pokemonId: Int): Result<PokemonSpecieResponse, ResultError>

    suspend fun getPokemonEvolutionChain(chainId: Int): Result<PokemonEvolutionResponse, ResultError>
}