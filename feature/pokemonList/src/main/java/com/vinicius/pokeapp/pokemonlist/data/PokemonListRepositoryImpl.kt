package com.vinicius.pokeapp.pokemonlist.data

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokeapp.service.service.PokeappService
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokeappService: PokeappService
) : PokemonListRepository {

    override suspend fun fetchPokemons(): Result<List<Pokemon>, String> {
        val result = pokeappService.fetchPokemons()

        return if (result.isNullOrEmpty().not()) {
            Result.Success(result)
        } else {
            Result.Error("")
        }
    }

}