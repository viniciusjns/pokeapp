package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokeapp.service.service.PokeappService
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService
) : PokemonListRemoteDataSource {

    override suspend fun fetchPokemons(): Result<List<Pokemon>, String> {
        return try {
            val result = pokeappService.fetchPokemons()

            if (result.isNullOrEmpty()) {
                Result.Success(emptyList())
            } else {
                Result.Success(result)
            }
        } catch (ex: Exception) {
            Result.Error("")
        }
    }
}