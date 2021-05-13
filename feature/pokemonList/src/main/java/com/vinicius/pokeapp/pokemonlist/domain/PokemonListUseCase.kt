package com.vinicius.pokeapp.pokemonlist.domain

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.service.response.Pokemon

interface PokemonListUseCase {
    suspend fun fetchPokemons(): Result<List<Pokemon>, String>
}