package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError

interface PokemonListRemoteDataSource {

    suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError>
}