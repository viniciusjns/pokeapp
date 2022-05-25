package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.core.extensions.safeApiCall
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonEvolutionResponse
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonSpecieResponse
import com.vinicius.pokeapp.pokemondetail.data.service.PokeappEvolutionService
import javax.inject.Inject

class PokemonDetailRemoteDataSourceImpl @Inject constructor(
    private val service: PokeappEvolutionService
) : PokemonDetailRemoteDataSource {

    override suspend fun getPokemonSpecie(pokemonId: Int):
            Result<PokemonSpecieResponse, ResultError> =
        safeApiCall {
            service.getPokemonSpecie(pokemonId)
        }

    override suspend fun getPokemonEvolutionChain(chainId: Int):
            Result<PokemonEvolutionResponse, ResultError> =
        safeApiCall {
            service.getPokemonEvolutionChain(chainId)
        }

}