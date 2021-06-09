package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.service.response.Pokemon

interface PokemonListRemoteDataSource {

    suspend fun fetchPokemons(): Result<List<Pokemon>, String>
}