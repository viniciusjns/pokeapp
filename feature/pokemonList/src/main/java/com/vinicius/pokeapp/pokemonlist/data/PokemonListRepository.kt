package com.vinicius.pokeapp.pokemonlist.data

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.service.response.Pokemon

interface PokemonListRepository {

    suspend fun fetchPokemons(): Result<List<Pokemon>, String>
}