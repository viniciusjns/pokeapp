package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.database.entity.PokemonEntity

interface PokemonListLocalDataSource {
    suspend fun getPokemons(): List<PokemonEntity>

    suspend fun savePokemons(pokemons: List<PokemonEntity>)
}