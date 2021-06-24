package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonDataModel

interface PokemonListRemoteDataSource {

    suspend fun fetchPokemons(): Result<List<PokemonDataModel>, String>
}