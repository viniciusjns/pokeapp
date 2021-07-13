package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDataModel

interface PokemonDetailLocalDataSource {

    suspend fun getPokemonById(id: Int): Result<PokemonDataModel, String>
}