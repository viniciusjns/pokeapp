package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse
import com.vinicius.pokeapp.pokemonlist.data.service.PokeappService
import com.vinicius.pokeapp.core.util.safeApiCall
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService
) : PokemonListRemoteDataSource {

    override suspend fun getPokemons(): Result<List<PokemonResponse>, ResultError> =
        safeApiCall {
            pokeappService.fetchPokemons()
        }
}