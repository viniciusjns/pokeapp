package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.database.entity.PokemonEntity

interface PokemonDetailLocalDataSource {
    suspend fun getPokemonById(id: Int): PokemonEntity?
}