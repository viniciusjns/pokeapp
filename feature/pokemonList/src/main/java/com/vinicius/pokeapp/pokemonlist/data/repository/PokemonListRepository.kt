package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel

interface PokemonListRepository {

    suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String>
}