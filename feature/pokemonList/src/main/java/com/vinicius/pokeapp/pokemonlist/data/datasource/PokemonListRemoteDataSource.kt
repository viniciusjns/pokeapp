package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel

interface PokemonListRemoteDataSource {

    suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String>
}