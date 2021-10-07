package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError

interface PokemonListLocalDataSource {
    suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError>
}