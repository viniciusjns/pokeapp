package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import com.vinicius.pokeapp.service.response.Pokemon
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository
) : PokemonListUseCase {

    override suspend fun fetchPokemons(): Result<List<Pokemon>, String> {
        return pokemonListRepository.fetchPokemons()
    }
}