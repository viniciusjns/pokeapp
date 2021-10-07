package com.vinicius.pokeapp.pokemonlist.domain.repository

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError

interface PokemonListRepository {
    suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError>
}