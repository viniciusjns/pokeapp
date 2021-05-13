package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.PokemonListRepository
import com.vinicius.pokeapp.service.response.Pokemon
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : PokemonListUseCase {

    override suspend fun fetchPokemons(): Result<List<Pokemon>, String> {
        return when (val result = pokemonListRepository.fetchPokemons()) {
            is Result.Success -> {
                result.onSuccess { it }
            }
            is Result.Error -> {
                result.mapError { it }
            }
        }
    }
}