package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonDataModel

interface PokemonListRepository {

    suspend fun fetchPokemons(): Result<List<PokemonDataModel>, String>
}