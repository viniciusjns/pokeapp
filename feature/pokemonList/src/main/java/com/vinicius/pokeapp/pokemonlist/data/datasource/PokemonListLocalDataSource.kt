package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.database.entity.PokemonEntity

interface PokemonListLocalDataSource {
    suspend fun getPokemons(): List<PokemonEntity>

    suspend fun savePokemons(pokemons: List<PokemonEntity>)
}