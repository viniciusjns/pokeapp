package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel

interface PokemonListRepository {

    suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String>
}